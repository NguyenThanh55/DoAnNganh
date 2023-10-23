import React, { useEffect, useState } from "react";
import axiosClient, { endpoints } from "../../api/axiosClient";
import { useParams } from "react-router-dom";
import { error } from "jquery";
import './depart.scss';
import { Row } from "react-bootstrap";

const DepartItem = ({ departId }) => {
    const [depart, setDepart] = useState(null);
    const { id } = useParams();

    useEffect(() => {
        axiosClient.get(`${endpoints['departInfo']} + ${id}`)
            .then(response => {
                setDepart(response.data);
            }).catch(error => {
                console.log('Error fetching depart:', error);
            })
    })

    if (!depart) {
        return <div>Chưa có dữ liệu...</div>;
    }


    return (
        <>
            <Row>
                <h1 className="depart">{depart.name}</h1>
                <h5>{depart.description}</h5>
                <h2 className="font-bold">Chương trình đào tạo:</h2>
                <h5 className="mb-3">{depart.educationProgram}</h5>
                <h2 className="font-bold">Website khoa:</h2> <h5 className="mb-3">{depart.website}</h5>
                <h2 className="font-bold">Video giới thiệu:</h2>
                <video controls width="400" height="300">
                    <source src={depart.introduceVideo} type="video/mp4" />
                </video>
                <hr />
                <h2 className="font-bold">Điểm trung bình trúng tuyển:</h2>
                <div dangerouslySetInnerHTML={{ __html: depart.averageScore }} />
            </Row>
        </>
    );
}

export default DepartItem;

