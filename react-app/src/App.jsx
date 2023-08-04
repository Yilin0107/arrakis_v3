import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from "react";
import './App.css';
import SignIn from './components/SignIn';
import FinancialDashboard from './components/FinancialDashboard';
import { Route, Routes } from 'react-router-dom'; 

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false); 

  
  const handleLogin = () => {
    setIsLoggedIn(true);
  };

  return (
    <>
      <Routes>
        <Route path="/login" element={<SignIn setIsLoggedIn={setIsLoggedIn} />} />
        <Route path="/dashboard" element={<FinancialDashboard />} />
      </Routes>
    </>
   
  );
}

export default App;