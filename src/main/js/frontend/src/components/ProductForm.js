import React, { useState } from "react";
import { Button, Form, FormGroup, FormText, Label, Input } from "reactstrap";
import "bootstrap/dist/css/bootstrap.css";
import axios from "axios";

const ProductForm = ({ onSubmit, setProductList }) => {
	const [productName, setProductName] = useState("");
	const [productPrice, setProductPrice] = useState("");
	const [warningText, setWarningText] = useState("");

	const addProduct = (e) => {
		e.preventDefault();
		setWarningText("")
		if (productName === '' || productPrice === '') {
			setWarningText("Name or price is empty!")
			return;
		} else if (isNaN(productPrice)) {
			setWarningText("Price is not a number!")
		} else if (productPrice < 0) {
			setWarningText("Price must be positive value!")
		}
		else {
			onSubmit();
			var headers = {
				"Content-Type": "application/json",
			};
			const product = {
				name: productName,
				standardPrice: productPrice,
			};

			axios
				// .post("https://hidden-shore-25886.herokuapp.com/products", product, headers)
				.post("/products", product, headers)
				.then((res) => setProductList((oldArray) => [...oldArray, res.data]));
		}
	};

	return (
		<Form onSubmit={addProduct}>
			<FormGroup controlId="formProductName">
				<Label for="productName">Product name</Label>
				<Input
					type="text"
					placeholder="Enter product name"
					value={productName}
					onChange={(e) => setProductName(e.target.value)}
				/>
			</FormGroup>
			<FormGroup controlId="formProductPrice">
				<Label for="productPrice">Product price</Label>
				<Input
					type="text"
					placeholder="Product price"
					value={productPrice}
					onChange={(e) => setProductPrice(e.target.value)}
				/>
			</FormGroup>
			<Button variant="primary" type="submit" block>
				Add
			</Button>
			<br /><FormText color="danger">{warningText}</FormText>
		</Form>
	);
};
export default ProductForm;
