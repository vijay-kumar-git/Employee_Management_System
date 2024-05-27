import axios from 'axios';
import { useEffect, useState } from "react";

function Employee() {
    const [employeeId, setId] = useState('');
    const [employeeName, setName] = useState("");
    const [employeeAddress, setAddress] = useState("");
    const [mobile, setMobile] = useState("");
    const [employees, setEmployees] = useState([]);

    useEffect(() => {
        (async () => await loadEmployees())();
    }, []);

    async function loadEmployees() {
        const result = await axios.get("http://localhost:8081/api/v1/employee/getall");
        setEmployees(result.data);
    }

    async function save(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8081/api/v1/employee/save", {
                employeename: employeeName,
                employeeaddress: employeeAddress,
                mobile: mobile
            });
            alert("Employee registration Successful");
            setId("");
            setName("");
            setAddress("");
            setMobile("");
            loadEmployees();
        } catch (err) {
            alert("Employee Registration Failed");
        }
    }

    async function editEmployee(employee) {
        setName(employee.employeename);
        setAddress(employee.employeeaddress);
        setMobile(employee.mobile);
        setId(employee._id);
    }

    async function deleteEmployee(employeeId) {
        await axios.delete(`http://localhost:8081/api/v1/employee/delete/${employeeId}`);
        alert("Employee deleted Successfully");
        loadEmployees();
    }

    async function update(event) {
        event.preventDefault();
        try {
            await axios.put(`http://localhost:8081/api/v1/employee/edit/${employeeId}`, {
                employeename: employeeName,
                employeeaddress: employeeAddress,
                mobile: mobile
            });
            alert("Registration Updated");
            setId("");
            setName("");
            setAddress("");
            setMobile("");
            loadEmployees();
        } catch (err) {
            alert("Update Failed");
        }
    }

    return (
        <div>
            <h1>Employee Details</h1>
            <div className="container mt-4">
                <form>
                    <div className="form-group">
                        <label>Employee Name</label>
                        <input type="text" className="form-control" id="employeename"
                               value={employeeName}
                               onChange={(event) => setName(event.target.value)}
                        />
                    </div>
                    <div className="form-group">
                        <label>Employee Address</label>
                        <input type="text" className="form-control" id="employeeaddress"
                               value={employeeAddress}
                               onChange={(event) => setAddress(event.target.value)}
                        />
                    </div>
                    <div className="form-group">
                        <label>Mobile</label>
                        <input type="text" className="form-control" id="mobile"
                               value={mobile}
                               onChange={(event) => setMobile(event.target.value)}
                        />
                    </div>
                    <div>
                        <button className="btn btn-primary mt-4" onClick={save}>Register</button>
                        <button className="btn btn-warning mt-4" onClick={update}>Update</button>
                    </div>
                </form>
            </div>
            <br/>
            <table className="table table-dark" align="center">
                <thead>
                <tr>
                    <th scope="col">Employee Name</th>
                    <th scope="col">Employee Address</th>
                    <th scope="col">Mobile</th>
                    <th scope="col">Option</th>
                </tr>
                </thead>
                <tbody>
                {employees.map(employee => (
                    <tr key={employee._id}>
                        <td>{employee.employeename}</td>
                        <td>{employee.employeeaddress}</td>
                        <td>{employee.mobile}</td>
                        <td>
                            <button type="button" className="btn btn-warning"
                                    onClick={() => editEmployee(employee)}>Edit
                            </button>
                            <button type="button" className="btn btn-danger"
                                    onClick={() => deleteEmployee(employee._id)}>Delete
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default Employee;