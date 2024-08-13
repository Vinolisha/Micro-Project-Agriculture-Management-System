import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { FaTrashAlt, FaEdit } from "react-icons/fa";
import { RiDeleteBinFill } from "react-icons/ri";
import { Link, useNavigate} from "react-router-dom";
import Service from "../SellerProductService/Service";

import axios from "axios";

export default function GetSellerProduct() {
  let navigate = useNavigate();

  

  const [Record, setRecord] = useState([]);
  const [search, setSearch] = useState("");
 



  useEffect(() => {
    loadRecord();
  }, []);

  const loadRecord = async () => {
    // console.log("hii");
    // await Service.GetAllProd().then((res) => setRecord(res.data));
    axios.get("http://localhost:8090/SellerProduct/findAllProduct").then((res) => {
      console.log(res);
      setRecord(res.data);
    });
  };

  const searchproduct =Record.filter((pro) => {
    return pro.productName.toLowerCase().includes(search.toLowerCase());
  })
 
  const removeDetails = async (e, productId) => {
    e.preventDefault();
    if (window.confirm("Are you sure?")) {
      console.log(productId)
      await Service.DeleteProduct(productId);
      window.location.reload();
      navigate("#");
    } else {
      alert("cancelled");
    }
  };

  

  return (
    <div className="container">
      
      <div className="col-4 mt-5">
        
        {/* <Link className="btn btn-dark m-2" to="/addproduct" id="add">
          Add Product{" "}
          <b>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-bag-plus-fill"
              viewBox="0 0 16 16"
            >
              <path
                fill-rule="evenodd"
                d="M10.5 3.5a2.5 2.5 0 0 0-5 0V4h5zm1 0V4H15v10a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V4h3.5v-.5a3.5 3.5 0 1 1 7 0M8.5 8a.5.5 0 0 0-1 0v1.5H6a.5.5 0 0 0 0 1h1.5V12a.5.5 0 0 0 1 0v-1.5H10a.5.5 0 0 0 0-1H8.5z"
              />
            </svg>
          </b>
        </Link> */}
      </div>
      <div className="py-">
      
        {searchproduct.length > 0 ? (
          <table class="table table-transparent table-striped shadow ">
            <thead>
              <tr>
                <th scope="col">Product Id</th>
                <th scope="col">Product Image</th>

                <th scope="col">category</th>
                <th scope="col">productName</th>
                <th scope="col">description</th>
                <th scope="col">quantity</th>
                <th scope="col">price</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody className="text-center">
              {searchproduct.map((product, index) => (
                <tr>
                  <th scope="row" key={index}>
                    {product.productId}
                  </th>

                  {/* <td>{product.imageProduct}</td> */}
                  <td><img src={"http://localhost:8090/SellerProduct/findProdImage/"+product.productId} width="100" height="100" /></td>                  <td>{product.category}</td>
                  <td>{product.productName}</td>
                  <td>{product.description}</td>
                  <td>{product.quantity}Kg</td>
                  <td>{product.price}₹</td>

                  <td>
                    {/* <Link
                      className="btn btn-dark mx-2"
                      to={`/updatedep/${product.prodId}`}
                    >
                      <FaEdit />
                    </Link> */}

                    <button
                      className="btn btn-outline-success"
                      onClick={(e) => removeDetails(e, product.productId)}
                    >
                      <RiDeleteBinFill />
                    </button>
                  </td>

              
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <div className="container m-lg-5">
          <div className="col-md-10 m-lg-5 ">
            <div className="col-md-6 offset-md-3 border rounded p-2 shadow  bg-light">
              <h1 className="text-center p-2">
                    Record Not found
              </h1>
             <br>
             </br>
             </div>
             </div>
             </div>
        )}
            <Link className="btn btn-light m-2" to="/homePage" id="add">
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-arrow-counterclockwise"
                viewBox="0 0 16 16"
            >
                <path
                fill-rule="evenodd"
                d="M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2z"
                />
                <path d="M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466" />
            </svg>{"/"}
            Back
            </Link>
      </div>
    </div>
  );
}
