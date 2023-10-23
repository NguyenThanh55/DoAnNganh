import React, { useEffect, useState } from 'react';
import { Link, useSearchParams } from 'react-router-dom';
import axiosClient, { endpoints } from '../../api/axiosClient';
import Banner from '../Banner/Banner';
import { Card } from 'react-bootstrap';

const Search = () => {
    const [posts, setPosts] = useState([]);
    const [q] = useSearchParams();

    useEffect(() => {
        let loadPosts = async () => {
            try {
                let e = endpoints['posts'];
                let kw = q.get('kw');
                if (kw !== null)
                    e = `${e}?kw=${kw}`;
                let res = await axiosClient.get(e);
                setPosts(res.data);
                console.log(res.data);
            } catch (ex) {
                console.error(ex);
            }
        }

        loadPosts();
    }, [q])

    if (posts.length === 0)
        return (<><div>Không có tên bài thông báo này</div></>)


    return (
        <>
            <ul className='ListPostTS' >
                {posts.map(post => (
                    <li key={post.id}>
                        <Card className='card_post'>
                            <Card.Img variant="top" src={post.image} />
                            <Card.Body>
                                <Card.Title><Link className='deco_post' to={`/post_info/${post.id}`}>{post.title}</Link></Card.Title>
                            </Card.Body>
                        </Card>
                    </li>
                ))}
            </ul>
        </>
    );
};

export default Search;