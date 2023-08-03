import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import './App.css';
import AllBonds from "./components/AllBonds";
import SignIn from './components/SignIn';
import { Dashboard } from '@mui/icons-material';
import FinancialDashboard from './components/FinancialDashboard';

const App = () => {
  return (
    <div>
      
    <FinancialDashboard />

    </div>
  

  );
}

export default App;
