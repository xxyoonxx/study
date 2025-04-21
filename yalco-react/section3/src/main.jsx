import React from 'react';
import { createRoot } from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import PropsApp from './props/PropsApp.jsx';
import EventApp from './event/EventApp.jsx';
import StateApp from './state1/StateApp.jsx';
import StateApp2 from "./state2/StateApp2.jsx";
import UseReducerApp from "./usereducer/UseReducerApp.jsx";
import UseRefApp from "./useRef/UseRefApp.jsx";
import UseEffectApp from "./useeffect/UseEffectApp.jsx";
import HookApp from "./hooks/HookApp.jsx";
import UseFetchApp from "./usefetch/UseFetchApp.jsx";

createRoot(document.getElementById('root')).render(
    <BrowserRouter>
        <Routes>
            <Route path="/props" element={<PropsApp />} />
            <Route path="/event" element={<EventApp />} />
            <Route path="/state" element={<StateApp />} />
            <Route path="/state2" element={<StateApp2 />} />
            <Route path="/usereducer" element={<UseReducerApp />} />
            <Route path="/useref" element={<UseRefApp />} />
            <Route path="/useeffect" element={<UseEffectApp />} />
            <Route path="/hooks" element={<HookApp />} />
            <Route path="/usefetch" element={<UseFetchApp />} />
        </Routes>
    </BrowserRouter>
);
