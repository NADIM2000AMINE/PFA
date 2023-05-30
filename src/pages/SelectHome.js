import { Table } from "react-bootstrap";
import { Link} from "react-router-dom";
export default function Home() {

return (
    <div className="container">
        <div
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        fontWeight: "bold",
        
      }}
    >
      <p>Select user or auditeur</p>
    </div>
    <div className="py-4">
      <table className="table border shadow">
       
      
                <tbody>
          
                    <tr>
              
                        <td>
                            <Link
                            className="btn btn-primary mx-2"
                            to={`/Userhome`}>
                            User
                            </Link>
                        </td>
                        <td>
                            <Link
                            className="btn btn-primary mx-2"
                            to={`/Home`}>
                            Auditeur
                            </Link>
                        </td>
                    </tr>
          
        </tbody>
      </table>
    </div>
  </div>
    

//     <Link
//     className="btn btn-primary mx-2"
//     to={`ViewAuditeur/${auditeur.id}`}
//   >
//     View
//   </Link>
 
)
}