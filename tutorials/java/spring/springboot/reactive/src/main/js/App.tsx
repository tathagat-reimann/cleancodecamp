// src/main/typescript/App.tsx
import React, { useEffect, useState } from 'react';
import { createRoot } from 'react-dom/client';
import ButtonUsage from './components/ButtonUsage';
import DenseTable from './components/DenseTable';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';


const darkTheme = createTheme({
    palette: {
        mode: 'dark',
    },
});

const App: React.FC = () => {
    const [options, setOptions] = useState<string[]>([]);

    useEffect(() => {
        const eventSource = new EventSource('/api/accounts');

        eventSource.onmessage = (event) => {
            const newOption = event.data;
            setOptions(prevOptions => [...prevOptions, newOption]);
        };

        eventSource.onerror = (error) => {
            console.error('Error fetching options:', error);
            eventSource.close();
        };

        return () => {
            eventSource.close();
        };
    }, []);

    return (
        <ThemeProvider theme={darkTheme}>
            <CssBaseline />
            <Box sx={{ flexGrow: 1 }}>
                <Grid container spacing={2}>
                    <Grid size={3}/>
                    <Grid size={6}>
                        <DenseTable data={options} />
                    </Grid>
                    <Grid size={3}/>
                </Grid>
            </Box>

        </ThemeProvider>
    );
};

const container = document.getElementById('root');
const root = createRoot(container!);
root.render(<App />);