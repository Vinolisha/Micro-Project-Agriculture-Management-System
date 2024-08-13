import React, { useEffect, useState } from "react";
import CartServicee from "../FarmerProduct/CartServicee";
import Cart from "./Cart";
import { Link } from "react-router-dom";
import CartNavbar from "./CartNavbar";
import axios from 'axios'; // Import axios

function SeedCartSample() {
  const [record, setRecord] = useState([]);
  const [totalAmount, setTotalAmount] = useState(0);

  useEffect(() => {
    CartServicee.findAll().then((res) => {
      console.log(res.data);
      setRecord(res.data);
      calculateTotalAmount(res.data);
    });
  }, []);

  const calculateTotalAmount = (data) => {
    let total = 0;
    data.forEach((item) => {
      total += item.farmerProduct.price * item.farmerProduct.quantity;
    });
    setTotalAmount(total);
  };

  const handleRemoveItem = async (e, cartId) => {
    e.preventDefault();
    try {
      const response = await axios.delete(`http://localhost:8090/deleteCart/${cartId}`);
      console.log("Delete response:", response); // Now 'response' is properly defined
      // If deletion is successful, you may want to perform some action, such as refreshing the cart
      // For example, you can reload the page to reflect the changes
      // window.location.reload();
      // Instead of reloading the page, you can remove the item from the state directly to reflect the changes instantly
      setRecord(prevRecord => prevRecord.filter(item => item.sellerProduct.productId !== cartId));
    } catch (error) {
      console.error("Error deleting product:", error);
      // Handle error, show a message to the user, etc.
    }
  };

  return (
    <div className="container py-5 mt-5">
      <CartNavbar/>
      <div className="row justify-content-center">
        <div className="col-lg-8">
          {record.map((data) => (
            <Cart
              key={data.sellerProduct.productId}
              productName={data.sellerProduct.productName}
              productPrice={data.sellerProduct.price}
              productId={data.sellerProduct.productId}
              productQuantity={data.sellerProduct.quantity}
              totalPrice={data.sellerProduct.totalPrice}
              handleRemoveItem={handleRemoveItem} // Pass the handleRemoveItem function as a prop to the Cart component
            />
          ))}
        </div>
        <div className="col-lg-8 mt-5 text-center ">
        <h4>Total Amount: ₹{totalAmount}</h4>
        <div className="d-flex justify-content-center">
          <Link
            className="btn btn-primary btn-lg mb-3"
            to="/combinedPayment"
          >
            Buy Now
          </Link>
          <Link className="btn btn-outline-success btn-lg" to="/sampleSeedShoping">
            Continue Shopping
          </Link>
          </div>
        </div>
      </div>
    </div>
  );
}

export default SeedCartSample;
