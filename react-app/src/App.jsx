import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignIn from './services/SignIn';
import AllBonds from "./components/AllBonds";
import AllTrades from "./components/AllTrades";


function App() {
  return (
      <Router>
          <Routes>
              <Route path="/" element={<SignIn />} />
              <Route path="/bonds" element={<AllBonds />} />
              <Route path="/trades" element={<AllTrades />} />
          </Routes>
      </Router>
  );
}

export default App;
