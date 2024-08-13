import React, { useState, useEffect } from "react";
import { Card, Button } from "react-bootstrap";
import {Grid} from "@mui/material"
import axios from "axios";

import CartServicee from "./CartServicee";

export default function AddingProduct(props) {
  const [record, setRecord] = useState([]);

  const [search, setSearch] = useState("");
  const [wishlist, setWishlist] = useState([]);

  useEffect(() => {
    loadRecord();
  }, []);

  const loadRecord = async () => {
    try {
      const res = await axios.get(
        "http://localhost:8090/FarmerProduct/findAllProduct"
      );
      setRecord(res.data);
      console.log(res.data);
    } catch (error) {
      console.error("Error loading products:", error);
    }
  };

  const searchProduct = record.filter((pro) => {
    return pro.productName.toLowerCase().includes(search.toLowerCase());
  });

  const [Details, setDetails] = React.useState({
    farmerProduct: {
      productId: "",
    },
    customer: {
      customerId: "",
    },
  });

  const addToCart = (prodId, prodName, prodPrice, prodQuantity) => {
    const customerId = sessionStorage.getItem("customerId");
    const data = { prodId, prodName, prodPrice, prodQuantity };
    const productId = prodId;
    const quantity = prodQuantity;
    const totalPrice = prodPrice;
    const productName = prodName;

    const cartData = {
      farmerProduct: { productId },
      quantity,
      totalPrice,
      productName,
      customer: { customerId },
    };

    console.log(cartData);
    CartServicee.addCart(cartData)
      .then((response) => {})
      .catch((e) => alert("Item is already added"));
  };

  const addToWishlist = (product) => {
    const existingItem = wishlist.find(
      (item) => item.productId === product.productId
    );
    if (!existingItem) {
      setWishlist([...wishlist, { ...product }]);
    }
  };

  return (
    <Grid item xs={4}>
          <Card sx={{
            width: 300,
            height: 400,
            margin: 10,

          }}>
            <Card.Img
              variant="top"
              src={
                "http://localhost:8090/FarmerProduct/findProdImage/" +
                props.productid
              }
              height="200"
              onLoad={() => {
                console.log("Image loaded successfully");
              }}
              onError={(e) => {
                console.log("Image not found");
                e.target.src = "path/to/fallback/image.jpg"; // Set a fallback image if the original image is not found
              }}
            />
            <Card.Body>
              <Card.Title>{props.productName}</Card.Title>
              <Card.Text>{props.productCategory}</Card.Text>
              <Card.Text>Quantity: {props.productQuantity} KG</Card.Text>
              <Card.Text>Price: {props.productPrice} ₹</Card.Text>
              <div className="d-flex justify-content-start align-items-center ms-4">
                <Button
                  onClick={() =>
                    addToCart(
                      props.productid,
                      props.productName,
                      props.productPrice,
                      props.productQuantity
                    )
                  }
                  variant="success"
                >
                  Add to Cart
                </Button>
                <div className="ms-1">
                  <Button onClick={() => addToWishlist(props)} variant="danger">
                    <i className="fas fa-heart"></i> Add to Wishlist
                  </Button>
                </div>
              </div>
            </Card.Body>
          </Card>
          </Grid>
  );
}
