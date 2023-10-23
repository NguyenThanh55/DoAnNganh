import React, { useEffect, useState } from "react";
import { Card, Tab, Tabs } from "react-bootstrap";
import axiosClient, { endpoints } from "../../api/axiosClient";
import '../Post/post.scss';
import { Link } from "react-router-dom";
const Department = () => {
    const [departList, setDepartState] = useState([])

    useEffect(() => {
        const getDepart = async () => {
            try {
                const res = await axiosClient.get(endpoints['departs']);
                setDepartState(res.data)
            } catch (error) {
                console.log(error.message)
            }
        }
        getDepart();
    }, [])

    return (
        <>
            <h1 class="text-center text-info mt-1">THÔNG TIN KHOA - NGÀNH</h1>

            <ul className="ListPostTS">
                {departList.map(d => (

                    <li key={d.id}>
                        <Card >
                            <Card.Img variant="top" src={d.image} alt={d.name} />
                            <Card.Body>
                                <Card.Title><Link to={`/depart_info/${d.id}`}>{d.name}</Link></Card.Title>
                            </Card.Body>
                        </Card>
                    </li>
                ))}
            </ul>
        </>
    );
}

export default Department;