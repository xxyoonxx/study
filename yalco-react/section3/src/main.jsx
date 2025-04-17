import React from 'react';
import { createRoot } from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import PropsApp from './props/PropsApp.jsx';
import EventApp from './event/EventApp.jsx';
import StateApp from './state1/StateApp.jsx';
import StateApp2 from "./state2/StateApp2.jsx";
import UseReducerApp from "./usereducer/UseReducerApp.jsx";
import UseRefApp from "./useRef/UseRefApp.jsx";

createRoot(document.getElementById('root')).render(
    <BrowserRouter>
        <Routes>
            <Route path="/props" element={<PropsApp />} />
            <Route path="/event" element={<EventApp />} />
            <Route path="/state" element={<StateApp />} />
            <Route path="/state2" element={<StateApp2 />} />
            <Route path="/usereducer" element={<UseReducerApp />} />
            <Route path="/useref" element={<UseRefApp />} />
        </Routes>
    </BrowserRouter>
);
