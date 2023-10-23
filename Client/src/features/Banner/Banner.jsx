import Carousel from 'react-bootstrap/Carousel';
import React, { useEffect, useState } from "react";
import axiosClient, { endpoints } from "../../api/axiosClient";
import { Link } from 'react-router-dom';

const Banner = () => {
    const [banner, setBanner] = useState([])
    useEffect(() => {
        const getBanner = async () => {
            try {
                const res = await axiosClient.get(endpoints['slide']);
                setBanner(res.data)
            } catch (error) {
                console.log(error.message)
            }
        }
        getBanner();
    }, [])
    return (
        <>
            <Carousel>
                {banner.map(banner => (
                    <Carousel.Item>
                        <Link to={banner.detailUrl}>
                            <img
                                className="d-block w-100"
                                src={banner.imageUrl}
                                alt="one slide"
                            />
                        </Link>
                        <Carousel.Caption>
                        </Carousel.Caption>
                    </Carousel.Item>
                ))}
            </Carousel>
        </>
    );
};

export default Banner;