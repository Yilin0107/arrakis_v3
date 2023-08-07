import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignIn from './services/SignIn';
import AllBonds from "./components/AllBonds";
import AllTrades from "./components/AllTrades";
import Maturity from './components/Maturity';
import FinancialDashboard from './components/FinancialDashboard'
const App = () => {
  return (
      <Router>
          <Routes>
              <Route path="/" element={<SignIn />} />
              <Route path="/dashboard" element={<FinancialDashboard />} />
              <Route path="/bonds" element={<AllBonds />} />
              <Route path="/trades" element={<AllTrades />} />
              <Route path="/maturity" element={<Maturity />} />
          </Routes>
      </Router>
  );
}

export default App;
