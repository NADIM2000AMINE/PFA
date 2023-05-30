import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function EditAuditeur() {
  let navigate = useNavigate();

  const { id } = useParams();

  const [Auditeur, setAuditeur] = useState({
    name: "",
    Auditeurname: "",
    email: "",
  });

  const { name, Auditeurname, email } = Auditeur;

  const onInputChange = (e) => {
    setAuditeur({ ...Auditeur, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    loadAuditeur();
  }, []);

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8080/Auditeur/${id}`, Auditeur);
    navigate("/");
  };

  const loadAuditeur = async () => {
    const result = await axios.get(`http://localhost:8080/Auditeur/${id}`);
    setAuditeur(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Edit Auditeur</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your name"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>
          
            
            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}