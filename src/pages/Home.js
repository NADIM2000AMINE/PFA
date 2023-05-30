import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function Home() {
  const [auditeurs, setauditeurs] = useState([]);

  const { id } = useParams();

  useEffect(() => {
    loadauditeurs();
  }, []);

  const loadauditeurs = async () => {
    const result = await axios.get("http://localhost:8080/Auditeurs");
    setauditeurs(result.data);
  };

  const deleteauditeur = async (id) => {
    await axios.delete(`http://localhost:8080/Auditeur/${id}`);
    loadauditeurs();
  };

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">N</th>
              <th scope="col">Name</th>
              <th scope="col">ID</th>
              <th scope="col">Action</th>
              
            </tr>
          </thead>
          <tbody>
            {auditeurs.map((auditeur, index) => (
              <tr>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{auditeur.name}</td>
                <td>{auditeur.id}</td>
                <td>
                  <Link
                    className="btn btn-primary mx-2"
                    to={`ViewAuditeur/${auditeur.id}`}
                  >
                    View
                  </Link>
                  <Link
                    className="btn btn-outline-primary mx-2"
                    to={`EditAuditeur/${auditeur.id}`}
                  >
                    Edit
                  </Link>
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => deleteauditeur(auditeur.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}