import React, { useState, useEffect } from "react";
import { Card, Button } from "react-bootstrap";
import axios from "axios";
import { Grid } from "@mui/material";
import CartSeedService from "../CartSeedService/Service"; 


export default function AddSeedShopingPage(props) {
  const [record, setRecord] = useState([]);
  const [search, setSearch] = useState("");
  const [wishlist, setWishlist] = useState([]);

  useEffect(() => {
    loadRecord();
  }, []);

  const loadRecord = async () => {
    try {
      const res = await axios.get(
        "http://localhost:8090/SellerProduct/findAllProduct"
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

  const addToCart = (prodId, prodName, prodPrice, prodQuantity) => {
    const farmerId = sessionStorage.getItem("farmerId");
    const data = { prodId, prodName, prodPrice, prodQuantity };
    const productId = prodId;
    const quantity = prodQuantity;
    const totalPrice = prodPrice;
    const productName = prodName;

    const cartData = {
      sellerProduct: { productId },
      quantity,
      totalPrice,
      productName,
      farmer: { farmerId },
    };

    CartSeedService.addSeedCart(cartData)
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
      <Card sx={{ width: 300, height: 400, margin: 10 }}>
        <Card.Img
          variant="top"
          src={`http://localhost:8090/SellerProduct/findProdImage/${props.productid}`}
          height="200"
          onLoad={() => {
            console.log("Image loaded successfully");
          }}
          onError={(e) => {
            console.log("Image not found");
            e.target.src = "path/to/fallback/image.jpg";
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
