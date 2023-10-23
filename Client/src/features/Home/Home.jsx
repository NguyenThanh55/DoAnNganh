import React, { useEffect, useState, useContext } from "react";
// import AlbumFeature from "../Album";
import './home.scss';
import ListPost1 from "../Post/ListPost1";
import ListPost2 from "../Post/ListPost2";
import ListPost3 from "../Post/ListPost3";
import ListPost4 from "../Post/ListPost4";
import ListPost5 from "../Post/ListPost5";
import { Link, useSearchParams } from "react-router-dom";
import axiosClient, { endpoints } from "../../api/axiosClient";
import Banner from "../Banner/Banner";
import { MyUserContext } from '../../App';
import NotificationLive from "../LiveStream/NotificationLive";
import { Card, Carousel, Col, Image, Row } from "react-bootstrap";
import { colors } from "@mui/material";
import { BsPlayCircleFill } from "react-icons/bs";


const Home = () => {
  const [user, dispatch] = useContext(MyUserContext);
  const [posts, setPosts] = useState(null);
  const [postsTintuc, setPostsTintuc] = useState([]);
  const [postsLichthi, setPostsLichthi] = useState([]);
  const [postsHDSV, setPostsHDSV] = useState([]);
  const [departSDH, setDepartSDH] = useState([]);
  const [departDHCQ, setDepartDHCQ] = useState([]);
  const [departDTTX, setDepartDTTX] = useState([]);
  const [postsHDKH, setPostsHDKH] = useState([]);
  const [postsHTQT, setPostsHTQT] = useState([]);
  const [postsTuyenDung, setPostsTuyenDung] = useState([]);
  const [postsCenter, setPostsCenter] = useState([]);
  const [listCates, setListCates] = useState([]);
  const [web, setWeb] = useState([]);
  const [q] = useSearchParams();
  useEffect(() => {
    let loadPosts = async () => {
      try {
        let e = endpoints['post'];
        let typeId = q.get("typeId");
        if (typeId !== null)
          e = `${e}?typeId=${typeId}`;

        let res = await axiosClient.get(e);
        setPosts(res.data);
      } catch (ex) {
        console.error(ex);
      }
    }

    let loadHome = async () => {
      try {
        let res1 = await axiosClient.get(endpoints['postsTinTuc']);
        let res2 = await axiosClient.get(endpoints['postsLichThi']);
        let res3 = await axiosClient.get(endpoints['postsHDSinhvien']);
        let res4 = await axiosClient.get(endpoints['depart_saudaihoc']);
        let res5 = await axiosClient.get(endpoints['depart_chinhquy']);
        let res6 = await axiosClient.get(endpoints['depart_daotaotuxa']);
        let res7 = await axiosClient.get(endpoints['postsHDKH']);
        let res8 = await axiosClient.get(endpoints['postsHTQT']);
        let res9 = await axiosClient.get(endpoints['postsTuyenDung']);
        setPostsTintuc(res1.data);
        setPostsLichthi(res2.data);
        setPostsHDSV(res3.data);
        setDepartSDH(res4.data);
        setDepartDHCQ(res5.data);
        setDepartDTTX(res6.data);
        setPostsHDKH(res7.data);
        setPostsHTQT(res8.data);
        setPostsTuyenDung(res9.data);
      } catch (ex) {
        console.error(ex);
      }
    }

    let loadPostsHome = async () => {
      try {
        let res7 = await axiosClient.get(endpoints['postsCenter']);
        let res8 = await axiosClient.get(endpoints['listCategories']);
        let res9 = await axiosClient.get(endpoints['website']);
        setPostsCenter(res7.data);
        setListCates(res8.data);
        setWeb(res9.data);
        console.log(res7.data);
      } catch (ex) {
        console.error(ex);
      }
    }

    loadPosts();
    loadHome();
    loadPostsHome();

  }, [q]);

  return (
    <>
      <div>
        <Banner />
        <h1 className="text-center text-sky-500 mt-7 info">THÔNG TIN TUYỂN SINH</h1>
        <Row>
          <div className="home">
            <div style={{ width: "80%" }}>
              <Row className="mb-5">
                <Col>
                  <h2 className="title">Tin tức</h2>
                  <Carousel>
                    {postsTintuc.map(banner => (
                      <Carousel.Item>
                        <Card className='card_post'>
                          <Card.Img variant="top" src={banner.imageUrl} />
                          <Card.Body>
                            <Card.Title><Link className='deco_post' to={banner.detailUrl}>{banner.title}</Link></Card.Title>
                          </Card.Body>
                        </Card>
                      </Carousel.Item>
                    ))}
                  </Carousel>
                </Col>
                <Col>
                  <h2 className="title">Lịch thi</h2>
                  <Carousel>
                    {postsLichthi.map(banner => (
                      <Carousel.Item>
                        <Card className='card_post'>
                          <Card.Img variant="top" src={banner.imageUrl} />
                          <Card.Body>
                            <Card.Title><Link className='deco_post' to={banner.detailUrl}>{banner.title}</Link></Card.Title>
                          </Card.Body>
                        </Card>
                      </Carousel.Item>
                    ))}
                  </Carousel>
                </Col>
                <Col>
                  <h2 className="title">Hoạt động sinh viên</h2>
                  <Carousel>
                    {postsHDSV.map(banner => (
                      <Carousel.Item>
                        <Card className='card_post'>
                          <Card.Img variant="top" src={banner.imageUrl} />
                          <Card.Body>
                            <Card.Title><Link className='deco_post' to={banner.detailUrl}>{banner.title}</Link></Card.Title>
                          </Card.Body>
                        </Card>
                      </Carousel.Item>
                    ))}
                  </Carousel>
                </Col>
              </Row>
              <Row className="mb-3">
                <h2>
                  <span className="cat_title_1 text-sky-500"> CÁC HỆ ĐÀO TẠO</span>
                </h2>
              </Row>
              <Row className="mb-5">
                <Col>
                  <h2 className="title text-center" style={{ backgroundColor: "lightblue" }}>ĐÀO TẠO <br /> SAU ĐẠI HỌC</h2>
                  <Carousel>
                    {departSDH.length >= 2 && (
                      <>
                        <Card className='card_post home_card_hedaotao'>
                          <Card.Img variant="top" src={departSDH[0].imageUrl} />
                          <Card.Body>
                            <Card.Title><Link className='deco_post' to={departSDH[0].detailUrl}>{departSDH[0].title}</Link></Card.Title>
                          </Card.Body>
                        </Card>
                        <Row>
                          <Card className='card_post' style={{ border: "none" }}>
                            <Card.Body>
                              <Card.Title>
                                <Link className='deco_post' to={departSDH[1].detailUrl}>
                                  {departSDH[1].title}
                                </Link>
                              </Card.Title>
                              <Card.Title><Link className='deco_post' to={departSDH[2].detailUrl}>{departSDH[2].title}</Link></Card.Title>
                              <Card.Title><Link className='deco_post btn_Xem' to="https://ou.edu.vn/tuyen_sinh_cat/sau-dai-hoc/">Xem thêm</Link></Card.Title>
                            </Card.Body>
                          </Card>
                        </Row>
                      </>
                    )}
                  </Carousel>
                </Col>
                <Col>
                  <h2 className="title text-center" style={{ backgroundColor: "rgb(27 214 120)" }}> ĐÀO TẠO <br /> CHÍNH QUY</h2>

                  {departDHCQ.length >= 2 && (
                    <>
                      <Card className='card_post home_card_hedaotao'>
                        <Card.Img variant="top" src={departDHCQ[0].imageUrl} />
                        <Card.Body>
                          <Card.Title><Link className='deco_post' to={departDHCQ[0].detailUrl}>{departDHCQ[0].title}</Link></Card.Title>
                        </Card.Body>
                      </Card>
                      <Row>
                        <Card className='card_post' style={{ border: "none" }}>
                          <Card.Body>
                            <Card.Title>
                              <Link className='deco_post' to={departDHCQ[1].detailUrl}>
                                {departDHCQ[1].title}
                              </Link>
                            </Card.Title>
                            <Card.Title><Link className='deco_post' to={departDHCQ[2].detailUrl}>{departDHCQ[2].title}</Link></Card.Title>
                            <Card.Title><Link className='deco_post btn_Xem' to="https://ou.edu.vn/tuyen_sinh_cat/daihoc_caodang/">Xem thêm</Link></Card.Title>
                          </Card.Body>
                        </Card>
                      </Row>
                    </>
                  )}
                </Col>
                <Col>
                  <h2 className="title text-center" style={{ backgroundColor: "rgb(239 136 140)" }}>ĐÀO TẠO <br /> TỪ XA</h2>

                  {departDTTX.length >= 2 && (
                    <>
                      <Card className='card_post home_card_hedaotao'>
                        <Card.Img variant="top" src={departDTTX[0].imageUrl} />
                        <Card.Body>
                          <Card.Title><Link className='deco_post' to={departDTTX[0].detailUrl}>{departDTTX[0].title}</Link></Card.Title>
                        </Card.Body>
                      </Card>
                      <Row>
                        <Card className='card_post' style={{ border: "none" }}>
                          <Card.Body>
                            <Card.Title>
                              <Link className='deco_post' to={departDTTX[1].detailUrl}>
                                {departDTTX[1].title}
                              </Link>
                            </Card.Title>
                            <Card.Title><Link className='deco_post' to={departDTTX[2].detailUrl}>{departDTTX[2].title}</Link></Card.Title>
                            <Card.Title><Link className='deco_post btn_Xem' to="https://ou.edu.vn/tuyen_sinh_cat/trung-tam-dao-tao-tu-xa/">Xem thêm</Link></Card.Title>
                          </Card.Body>
                        </Card>
                      </Row>
                    </>
                  )}
                </Col>
              </Row>
            </div>
            <div className="livestream">
              <div>
                <h2 className="title">
                  Thông tin tuyển sinh
                </h2>
                <div style={{ marginLeft: 20 + "px" }}>
                  <Row style={{ padding: 20 + "px", backgroundColor: "blue", marginBottom: 10 + "px" }}>
                    <a href="https://ou.edu.vn/tuyen_sinh_cat/daihoc_caodang/" style={{ textDecoration: "none", color: "white", fontWeight: "bold", textAlign: "center" }}>ĐẠI HỌC CHÍNH QUY</a>
                  </Row>
                  <Row style={{ padding: 20 + "px", backgroundColor: "red", marginBottom: 10 + "px" }}>
                    <a href="https://ou.edu.vn/tuyen_sinh_cat/sau-dai-hoc/" style={{ textDecoration: "none", color: "white", fontWeight: "bold", textAlign: "center" }}>ĐÀO TẠO SAU ĐẠI HỌC</a>
                  </Row>
                  <Row style={{ padding: 20 + "px", backgroundColor: "orange", marginBottom: 10 + "px" }}>
                    <a href="https://ou.edu.vn/tuyen_sinh_cat/trung-tam-dao-tao-tu-xa/" style={{ textDecoration: "none", color: "white", fontWeight: "bold", textAlign: "center" }}>ĐÀO TẠO TRỰC TUYẾN</a>
                  </Row>
                  <Row style={{ padding: 20 + "px", backgroundColor: "green" }}>
                    <a href="https://ou.edu.vn/tuyen_sinh_cat/trung-tam-dao-tao-tu-xa/" style={{ textDecoration: "none", color: "white", fontWeight: "bold", textAlign: "center" }}>ĐÀO TẠO TỪ XA</a>
                  </Row>
                </div>
              </div>
              <div>
                <h2 className="title">
                  HOẠT ĐỘNG KHOA HỌC
                </h2>
                {postsHDKH.length >= 1 && (
                  <div >
                    <Row style={{ padding: 8 + "px" }}>
                      <Col>
                        <a href={postsHDKH[0].detailUrl} style={{ textDecoration: "none", color: "black", fontWeight: "bold", textAlign: "center" }}>{postsHDKH[0].title}</a>
                      </Col>
                    </Row>
                    <Row style={{ padding: 8 + "px" }}>
                      <a href={postsHDKH[0].detailUrl} style={{ textDecoration: "none", color: "black", fontWeight: "bold", textAlign: "center" }}>{postsHDKH[1].title}</a>
                    </Row>
                    <Row style={{ padding: 8 + "px" }}>
                      <a href={postsHDKH[0].detailUrl} style={{ textDecoration: "none", color: "black", fontWeight: "bold", textAlign: "center" }}>{postsHDKH[2].title}</a>
                    </Row>
                  </div>
                )}
              </div>
              <div>
                <h2 className="title">
                  HỢP TÁC QUỐC TẾ
                </h2>
                {postsHTQT.length >= 1 && (
                  <div>
                    <Row style={{ padding: 8 + "px" }}>
                      <a href={postsHTQT[0].detailUrl} style={{ textDecoration: "none", color: "black", fontWeight: "bold", textAlign: "center" }}>{postsHTQT[0].title}</a>
                    </Row>
                    <Row style={{ padding: 8 + "px" }}>
                      <a href={postsHTQT[0].detailUrl} style={{ textDecoration: "none", color: "black", fontWeight: "bold", textAlign: "center" }}>{postsHTQT[1].title}</a>
                    </Row>
                    <Row style={{ padding: 8 + "px" }}>
                      <a href={postsHTQT[0].detailUrl} style={{ textDecoration: "none", color: "black", fontWeight: "bold", textAlign: "center" }}>{postsHTQT[2].title}</a>
                    </Row>
                  </div>
                )}
              </div>
              <div>
                <h2 className="title">
                  TUYỂN DỤNG
                </h2>
                {postsTuyenDung.length >= 1 && (
                  <div>
                    <Row style={{ padding: 8 + "px" }}>
                      <a href={postsTuyenDung[0].detailUrl} style={{ textDecoration: "none", color: "black", fontWeight: "bold", textAlign: "center" }}>{postsTuyenDung[0].title}</a>
                    </Row>
                    <Row style={{ padding: 8 + "px" }}>
                      <a href={postsTuyenDung[0].detailUrl} style={{ textDecoration: "none", color: "black", fontWeight: "bold", textAlign: "center" }}>{postsTuyenDung[1].title}</a>
                    </Row>
                    <Row style={{ padding: 8 + "px" }}>
                      <a href={postsTuyenDung[0].detailUrl} style={{ textDecoration: "none", color: "black", fontWeight: "bold", textAlign: "center" }}>{postsTuyenDung[2].title}</a>
                    </Row>
                  </div>
                )}
              </div>

            </div>
          </div>
        </Row>
        <Row>
          <h2 className="text-center text-sky-500 mt-3 info font-bold">TIN TỨC CHỌN LỌC TỪ CÁC KHOA VÀ TRUNG TÂM</h2>
          <div>
            {postsCenter.length > 0 && (<>
              <Row>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[0].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold">{postsCenter[0].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[0].date}</Row>
                    </Col>
                  </Row>
                </Col>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[1].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold" >{postsCenter[1].title}</Row>
                      <Row className="center" style={{ maxHeight: '100px', whiteSpace: 'wrap', overflow: 'hidden', textOverflow: 'ellipsis' }}>{postsCenter[1].date}</Row>
                    </Col>
                  </Row>
                </Col>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[2].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold">{postsCenter[2].title}</Row>
                      <Row className="center" style={{ maxHeight: '100px', whiteSpace: 'wrap', overflow: 'hidden', textOverflow: 'ellipsis' }}>{postsCenter[2].date}</Row>
                    </Col>
                  </Row>
                </Col>
              </Row>

              <Row>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[3].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold">{postsCenter[3].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[3].date}</Row>
                    </Col>
                  </Row>
                </Col>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[4].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold" >{postsCenter[4].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[4].date}</Row>
                    </Col>
                  </Row>
                </Col>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[5].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold">{postsCenter[5].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[5].date}</Row>
                    </Col>
                  </Row>
                </Col>
              </Row>

              <Row>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[6].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold">{postsCenter[6].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[6].date}</Row>
                    </Col>
                  </Row>
                </Col>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[7].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold" >{postsCenter[7].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[7].date}</Row>
                    </Col>
                  </Row>
                </Col>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[8].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold">{postsCenter[8].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[8].date}</Row>
                    </Col>
                  </Row>
                </Col>
              </Row>

              <Row>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[9].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold">{postsCenter[9].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[9].date}</Row>
                    </Col>
                  </Row>
                </Col>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[10].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold" >{postsCenter[10].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[10].date}</Row>
                    </Col>
                  </Row>
                </Col>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[11].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold">{postsCenter[11].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[11].date}</Row>
                    </Col>
                  </Row>
                </Col>
              </Row>

              <Row>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[12].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold">{postsCenter[12].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[12].date}</Row>
                    </Col>
                  </Row>
                </Col>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[13].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold" >{postsCenter[13].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[13].date}</Row>
                    </Col>
                  </Row>
                </Col>
                <Col>
                  <Row>
                    <Col><Image src={postsCenter[14].imageUrl} /></Col>
                    <Col>
                      <Row className="font-bold">{postsCenter[14].title}</Row>
                      <Row className="center" style={{
                        maxHeight: '100px', whiteSpace: 'wrap',
                        overflow: 'hidden', textOverflow: 'ellipsis'
                      }}>{postsCenter[14].date}</Row>
                    </Col>
                  </Row>
                </Col>
              </Row>
            </>
            )}
          </div >
        </Row >
        <Row>
          <h2 className="text-center text-sky-500 mt-3 info font-bold">LIÊN KẾT WEBSITE</h2>
          <div>
            {web.length > 0 && (
              <Row>
                <Col>
                  <Image src={web[2].imageUrl} />
                </Col>
                <Col>
                  <Image src={web[3].imageUrl} />
                </Col>
              </Row>
            )}
          </div>
        </Row>
      </div >
    </>
  );
};

export default Home;
