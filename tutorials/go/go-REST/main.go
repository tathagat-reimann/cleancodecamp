package main

import (
	"fmt"
	"net/http"
	"slices"
	"strconv"

	"github.com/go-chi/chi"
	"github.com/go-chi/chi/middleware"
	"github.com/go-chi/render"
)

type Blog struct {
	Id      int    `json:"id"`
	Title   string `json:"title"`
	Content string `json:"content"`
}

var blogs = []Blog{
	{1, "First Blog", "This is the first blog"},
	{2, "Second Blog", "This is the second blog"},
}

func main() {
	fmt.Println("Hello, and welcome to your new Blogs App!")

	r := chi.NewRouter()

	// Apply middleware
	r.Use(middleware.Logger)
	r.Use(middleware.Recoverer)
	r.Use(middleware.URLFormat)

	// Define routes
	r.Get("/", handleMainUrl)

	// Blog REST Endpoints
	setRoutesForBlog(r)

	// Start the server
	http.ListenAndServe(":8080", r)
}

func handleMainUrl(w http.ResponseWriter, r *http.Request) {
	render.PlainText(w, r, "Hello, and welcome to your new Blogs App!")
}

func setRoutesForBlog(r *chi.Mux) {
	r.Route("/blogs", func(r chi.Router) {
		r.Get("/", getAllBlogs)
		r.Get("/{id}", getBlog)
		r.Post("/", createBlog)
	})
}

func createBlog(w http.ResponseWriter, r *http.Request) {
	var blog Blog
	if err := render.DecodeJSON(r.Body, &blog); err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}

	if (blog.Title == "") || (blog.Content == "") {
		http.Error(w, "Title and Content are required", http.StatusBadRequest)
		return
	}

	blog.Id = len(blogs) + 1
	blogs = append(blogs, blog)
	render.JSON(w, r, blog)
}

func getAllBlogs(w http.ResponseWriter, r *http.Request) {
	render.JSON(w, r, blogs)
}

func getBlog(w http.ResponseWriter, r *http.Request) {
	id := chi.URLParam(r, "id")

	i := slices.IndexFunc(blogs,
		func(b Blog) bool {
			_id := strconv.Itoa(b.Id)
			return _id == id
		})

	if i == -1 {
		http.Error(w, http.StatusText(404), 404)
		return
	}

	render.JSON(w, r, blogs[i])
}
