import React from 'react';
import { createRoot } from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from './App';
import RenderingApp from './rendering/rederApp.jsx';
import ArrayApp from './array/arrayApp.jsx';

createRoot(document.getElementById('root')).render(
    <BrowserRouter>
        <Routes>
            <Route path="" element={<App />} />
            <Route path="/rendering" element={<RenderingApp />} />
            <Route path="/array" element={<ArrayApp />} />
        </Routes>
    </BrowserRouter>
);
