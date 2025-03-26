// src/main/typescript/App.tsx
import React, { useEffect, useState } from 'react';
import { createRoot } from 'react-dom/client';

const App: React.FC = () => {
    const [options, setOptions] = useState<string[]>([]);

    useEffect(() => {
        // Replace with your API endpoint
        fetch('/api/accounts')
            .then(response => response.json())
            .then(data => setOptions(data))
            .catch(error => console.error('Error fetching options:', error));
    }, []);

    return (
        <select>
            {options.map((option, index) => (
                <option key={index} value={option}>{option}</option>
            ))}
        </select>
    );
};

const container = document.getElementById('root');
const root = createRoot(container!);
root.render(<App />);