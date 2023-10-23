import React from 'react';
import { Alert, Button, Card, Col, Container, Form, Row } from 'react-bootstrap';
import { Navigate, useNavigate, useSearchParams } from 'react-router-dom';
import { useState } from 'react';
import { authApi, endpoints } from '../../api/axiosClient';

const InputOtp = ({
    otp: otp,
    user: user,
}) => {
    const [validated, setValidated] = useState(false);
    // const [username, setUsername] = useState();
    const [q] = useSearchParams();
    const [loading, setLoading] = useState(false);
    const nav = useNavigate();
    const [err, setErr] = useState(null);
    const [o, setO] = useState(null);

    const [taiKhoan, setTaiKhoanState] = useState({
        "newPassword": "",
        "confirmNewPassword": "",
    })

    const change = (evt, field) => {
        setTaiKhoanState(current => {
            return { ...current, [field]: evt.target.value }
        })
    }

    const submitOtp = (e) => {
        e.preventDefault();
        setValidated(true);

        const process = async () => {
            let formData = new FormData();
            console.log(user.username);
            formData.append("username", user.username);
            formData.append("newPassword", taiKhoan.newPassword);
            setLoading(true);
            let res = await authApi().post(endpoints['up-password'], formData);
            if (res.status === 200) {
                nav("/login");
            } else setErr("Hệ thống bị lỗi!");
        }

        if (taiKhoan.newPassword === taiKhoan.confirmNewPassword) {
            if (otp === o) {
                process();
            }
            else { setErr("Otp của bạn không hợp lệ!!!"); }
        } else { setErr("Mật khẩu không trùng!!!"); }
    }

    return (
        <>
            <Container>
                <Row className="vh-100 d-flex justify-content-center align-items-center">
                    <Col md={8} lg={6} xs={12}>
                        <div className="border border-3 border-primary"></div>
                        <Card className="shadow">
                            <Card.Body>
                                <div className="mb-3 mt-md-4">
                                    <h2 className="fw-bold mb-2 text-uppercase text-center">Quên mật khẩu</h2>
                                    <div className="mb-3">
                                        <Form noValidate validated={validated} onSubmit={submitOtp}>
                                            <Form.Group
                                                className="mb-3"
                                                controlId="formBasicPassword"
                                            >
                                                <p className=" textDky">Mật khẩu mới</p>
                                                <Form.Control
                                                    required
                                                    type="password"
                                                    value={taiKhoan.newPassword}
                                                    onChange={e => change(e, "newPassword")}
                                                    placeholder="Nhập mật khẩu mới ..." />
                                                <Form.Control.Feedback>Tuyệt vời!</Form.Control.Feedback>
                                                <Form.Control.Feedback type="invalid">
                                                    Vui lòng nhập mật khẩu mới!!!
                                                </Form.Control.Feedback>
                                            </Form.Group>
                                            <Form.Group
                                                className="mb-3"
                                                controlId="formBasicPassword"
                                            >
                                                <p className=" textDky">Xác nhận lại mật khẩu</p>
                                                <Form.Control
                                                    required
                                                    type="password"
                                                    value={taiKhoan.confirmNewPassword}
                                                    onChange={e => change(e, "confirmNewPassword")}
                                                    placeholder="Nhập lại mật khẩu mới ..." />
                                                <Form.Control.Feedback>Tuyệt vời!</Form.Control.Feedback>
                                                <Form.Control.Feedback type="invalid">
                                                    Vui lòng xác nhận lại mật khẩu!!!
                                                </Form.Control.Feedback>
                                            </Form.Group>
                                            <Form.Group className="mb-3" controlId="formBasicEmail">
                                                <p className="textDky">Nhập otp của bạn</p>
                                                <Form.Control
                                                    required
                                                    type="text"
                                                    value={o}
                                                    onChange={e => setO(e.target.value)}
                                                    placeholder="Nhập otp ..."
                                                />
                                                <Form.Control.Feedback></Form.Control.Feedback>
                                                <Form.Control.Feedback type="invalid">
                                                    Vui lòng nhập otp!!!
                                                </Form.Control.Feedback>
                                            </Form.Group>
                                            {loading === false && <div className="d-grid">
                                                <Button
                                                    variant="primary"
                                                    type="submit">
                                                    Gửi
                                                </Button>
                                            </div>}
                                            {err === null ? <div></div> : <Alert>{err}</Alert>}
                                        </Form>
                                    </div>
                                </div>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </>
    );
};

export default InputOtp;