import React, { useState, useEffect } from "react";
import { Container, Row, Col, Form, Button, Modal } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import "../Style/card.css";

const CombinedPage = () => {
  const initialFormData = {
    customerId: "",
    productId: "",
    orderDate: "", // No need to initialize here
    userName: "",
    buildingName: "",
    colonyName: "",
    cityName: "",
    stateName: "",
    contactNumber: "",
    cardNum: "",
    name: "",
    exp: "",
    cvv: "",
  };

  const [formData, setFormData] = useState(initialFormData);
  const [showConfirmation, setShowConfirmation] = useState(false);
  const [confirmationMessage, setConfirmationMessage] = useState("");
  const [currentDate, setCurrentDate] = useState("");

  useEffect(() => {
    const today = new Date();
    const year = today.getFullYear();
    const month = String(today.getMonth() + 1).padStart(2, "0");
    const day = String(today.getDate()).padStart(2, "0");
    const formattedDate = `${year}-${month}-${day}`;
    setCurrentDate(formattedDate);
    setFormData({ ...formData, orderDate: formattedDate });
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // Your axios request and other logic...
      // After successful submission:
      setConfirmationMessage("Your order has been confirmed!");
      setShowConfirmation(true);
      // Reset form fields
      setFormData({ ...initialFormData, orderDate: currentDate });
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const onInputChange = (e) => {
    const { name, value } = e.target;
    let updatedValue = value; // Initialize updated value with the entered value

    // Validation for each field
    switch (name) {
      case "userName":
        // Allow only letters
        updatedValue = value.replace(/[^A-Za-z\s]/gi, "");
        break;
      case "buildingName":
        // Allow only letters
        updatedValue = value.replace(/[^A-Za-z\s]/gi, "");
        break;
      case "colonyName":
        // Allow only letters
        updatedValue = value.replace(/[^A-Za-z\s]/gi, "");
        break;
      case "cityName":
        // Allow only letters
        updatedValue = value.replace(/[^A-Za-z\s]/gi, "");
        break;
      case "stateName":
        // Allow only letters
        updatedValue = value.replace(/[^A-Za-z\s]/gi, "");
        break;
      case "contactNumber":
        // Allow only numbers
        updatedValue = value.replace(/[^0-9]/g, "");
        break;
      case "cardNum":
        // Allow only numbers and spaces (for card number)
        updatedValue = value.replace(/[^0-9\s]/g, "");
        break;
      case "exp":
        // Allow only numbers and '/' character (for expiration date)
        updatedValue = value.replace(/[^0-9/]/g, "");
        break;
      case "cvv":
        // Allow only numbers (for CVV)
        updatedValue = value.replace(/[^0-9]/g, "");
        break;
      default:
        // No specific validation for other fields
        break;
    }

    // Update the form data with the validated value
    setFormData({ ...formData, [name]: updatedValue });
  };

  return (
    <Container>
      <Row>
        <Col md={6}>
          <div className="containerrs mt-5">
            <h1 className="forms-titles">Insert Crop Order</h1>
            <form onSubmit={handleSubmit}>
              <div className="mains-users-infos">
                <div className="users-inputs-boxs">
                  <label htmlFor="orderDate">Order Date</label>
                  <input
                    type="date"
                    id="orderDate"
                    name="orderDate"
                    value={formData.orderDate}
                    onChange={onInputChange}
                    required
                  />
                </div>
                <div className="users-inputs-boxs">
                  <label htmlFor="userName">User Name</label>
                  <input
                    type="text"
                    id="userName"
                    name="userName"
                    placeholder="Enter User Name"
                    value={formData.userName}
                    onChange={onInputChange}
                    required
                  />
                </div>
                <div className="users-inputs-boxs">
                  <label htmlFor="buildingName">Building Name</label>
                  <input
                    type="text"
                    id="buildingName"
                    name="buildingName"
                    placeholder="Enter Building Name"
                    value={formData.buildingName}
                    onChange={onInputChange}
                    required
                  />
                </div>
                <div className="users-inputs-boxs">
                  <label htmlFor="colonyName">Colony Name</label>
                  <input
                    type="text"
                    id="colonyName"
                    name="colonyName"
                    placeholder="Enter Colony Name"
                    value={formData.colonyName}
                    onChange={onInputChange}
                    required
                  />
                </div>
                <div className="users-inputs-boxs">
                  <label htmlFor="cityName">City Name</label>
                  <input
                    type="text"
                    id="cityName"
                    name="cityName"
                    placeholder="Enter City Name"
                    value={formData.cityName}
                    onChange={onInputChange}
                    required
                  />
                </div>
                <div className="users-inputs-boxs">
                  <label htmlFor="stateName">State Name</label>
                  <input
                    type="text"
                    id="stateName"
                    name="stateName"
                    placeholder="Enter State Name"
                    value={formData.stateName}
                    onChange={onInputChange}
                    required
                  />
                </div>
                <div className="users-inputs-boxs">
                  <label htmlFor="contactNumber">Contact Number</label>
                  <input
                    type="text"
                    id="contactNumber"
                    name="contactNumber"
                    placeholder="Enter Contact Number"
                    value={formData.contactNumber}
                    onChange={onInputChange}
                    required
                  />
                </div>
              </div>

            </form>
          </div>
        </Col>
        <Col md={6}>
          <div
            className="card mx-auto"
            style={{
              maxWidth: "450px",
              borderRadius: "15px",
              margin: "150px 0 150px",
              padding: "35px",
              paddingBottom: "20px!important",
            }}
          >
            <p
              className="heading"
              style={{ color: "#C1C1C1", fontSize: "14px", fontWeight: "500" }}
            >
              PAYMENT DETAILS
            </p>
            <Form onSubmit={handleSubmit}>
              <Form.Group className="mb-0">
                <Form.Label className="text-warning mb-0">
                  Card Number
                </Form.Label>
                <Form.Control
                  type="text"
                  name="cardNum"
                  placeholder="1234 5678 9012 3457"
                  value={formData.cardNum}
                  onChange={onInputChange}
                  style={{
                    borderBottom: "1.5px solid #E8E5D2!important",
                    fontWeight: "bold",
                    borderRadius: "0",
                    border: "0",
                  }}
                  minLength="19"
                  maxLength="19"
                  required
                />
                <img
                  src="https://img.icons8.com/color/48/000000/visa.png"
                  width="64px"
                  height="60px"
                  alt="Visa Logo"
                  style={{
                    transform: "translate(160px,-10px)",
                    cursor: "pointer",
                  }}
                />
              </Form.Group>

              <Form.Group className="pt-2">
                <Row>
                  <Col sm={4}>
                    <Form.Label className="text-warning mb-0">
                      Expiration
                    </Form.Label>
                    <Form.Control
                      type="text"
                      name="exp"
                      placeholder="MM/YYYY"
                      value={formData.exp}
                      onChange={onInputChange}
                      style={{
                        borderBottom: "1.5px solid #E8E5D2!important",
                        fontWeight: "bold",
                        borderRadius: "0",
                        border: "0",
                      }}
                      minLength="7"
                      maxLength="7"
                      required
                    />
                  </Col>
                  <Col sm={3}>
                    <Form.Label className="text-warning mb-0">Cvv</Form.Label>
                    <Form.Control
                      type="password"
                      name="cvv"
                      placeholder="&#9679;&#9679;&#9679;"
                      value={formData.cvv}
                      onChange={onInputChange}
                      style={{
                        borderBottom: "1.5px solid #E8E5D2!important",
                        fontWeight: "bold",
                        borderRadius: "0",
                        border: "0",
                      }}
                      minLength="3"
                      maxLength="3"
                      required
                    />
                  </Col>
                  <Col sm={5} className="pt-0">
                    <Button type="submit" className="btn-primary">
                      <i className="fas fa-arrow-right px-3 py-2"></i>
                    </Button>
                  </Col>
                </Row>
              </Form.Group>
            </Form>
          </div>
        </Col>
      </Row>
      {/* Modal for order confirmation */}
      <Modal show={showConfirmation} onHide={() => setShowConfirmation(false)}>
        <Modal.Header
          closeButton
          style={{
            backgroundColor: "#007bff",
            color: "white",
            borderBottom: "none",
          }}
        >
          <Modal.Title style={{ fontSize: "24px" }}>
            Order Confirmation
          </Modal.Title>
        </Modal.Header>
        <Modal.Body
          style={{
            backgroundColor: "#f8f9fa",
            color: "#212529",
            fontSize: "18px",
            padding: "20px",
            borderBottom: "1px solid #dee2e6",
          }}
        >
          {confirmationMessage}
        </Modal.Body>
        <Modal.Footer
          style={{
            borderTop: "none",
            backgroundColor: "#03642b ",
            justifyContent: "center",
          }}
        >
         
          <Button
          
            variant="secondary"
            
            onClick={() => setShowConfirmation(false)}
            style={{
              backgroundColor: "#6c757d",
              borderColor: "#6c757d",
              fontWeight: "bold",
            }} 
          >
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </Container>
  );
};

export default CombinedPage;
