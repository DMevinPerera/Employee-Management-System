import React from 'react'

const ListEmployeeComponent = () => {

    const dummyData = [
        {
            "id":1,
            "firstName":"Ramesh",
            "lastName":"Perera",
            "email":"dulanya2001@gmail.com"
        },
        {
            "id":2,
            "firstName":"Kevin",
            "lastName":"Perera",
            "email":"dulanyfa2001@gmail.com"
        },
        {
            "id":3,
            "firstName":"Tina",
            "lastName":"Perera",
            "email":"dulanya2aa001@gmail.com"
        },
        {
            "id":4,
            "firstName":"Ramess",
            "lastName":"Perera",
            "email":"dulanya200a1@gmail.com"
        },
    ]



  return (
    <div className='container'>
        <h2 className='text-center'>List of Employees</h2>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>Employee Email Id</th>
                </tr>
            </thead>
            <tbody>
                {
                    dummyData.map(employee => 
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent