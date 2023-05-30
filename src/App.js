import React from 'react';
import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Navbar from './layout/Navbar';
import { Routes, Route } from 'react-router-dom';
import Select from './pages/SelectHome';
import Home from './pages/Home';
import Homeforuser from './pages/Homeforuser';
import AddAuditeur from './auditeur/AddAuditeur';
import EditAuditeur from './auditeur/EditAuditeur';
import ViewAuditeur from './auditeur/ViewAuditeur';
import AddUser from './user/AddUser';
import EditUser from './user/EditUser';
import ViewUser from './user/ViewUser';

function App() {
  return (
    <div className="App">
      
        <Navbar />
        <Routes>
        <Route path="/" element={<Select />} />
          <Route path="/Home" element={<Home />} />
          <Route path="/Userhome" element={<Homeforuser />} />
           <Route path="/AddAuditeur" element={<AddAuditeur />} />
          <Route path="/EditAuditeur/:id" element={<EditAuditeur />} />
          <Route path="/ViewAuditeur/:id" element={<ViewAuditeur />} />
          <Route path="/AddUser" element={<AddUser />} />
          <Route path="/EditUser/:id" element={<EditUser />} />
          <Route path="/ViewUser/:id" element={<ViewUser />} /> 
        </Routes>
    
    </div>
  );
}

export default App;
