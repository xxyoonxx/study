import React from 'react';
import ReactDOM from 'react-dom/client';
import {BrowserRouter} from 'react-router-dom'
import CssBaseline from '@mui/material/CssBaseline'
import App from './App';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(
  <React.StrictMode>
      <BrowserRouter>
          <App/>
          <CssBaseline/>
      </BrowserRouter>
  </React.StrictMode>
);
