// src/main/typescript/App.tsx
import React, { useEffect, useState } from 'react';
import { createRoot } from 'react-dom/client';

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
        <table>
            <thead>
                <tr>
                    <th>Options</th>
                </tr>
            </thead>
            <tbody>
                {options.map((option, index) => (
                    <tr key={index}>
                        <td>{option}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
};

const container = document.getElementById('root');
const root = createRoot(container!);
root.render(<App />);