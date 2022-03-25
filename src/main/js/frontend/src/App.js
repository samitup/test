import React, { useState, useEffect } from "react";
import axios from "axios";
import { Button, Container, Col, Row, Modal, ModalBody, } from "reactstrap";
import "bootstrap/dist/css/bootstrap.css";
import ProductForm from "./components/ProductForm";
import CustomerForm from "./components/CustomerForm";
import CustomerTable from './components/CustomerTable'
import ProductTable from './components/ProductTable'
import RebateTable from './components/RebateTable'

const App = () => {
	const [productList, setProductList] = useState([]);
	const [customerList, setCustomerList] = useState([]);
	const [rebateProductList, setRebateProductList] = useState([]);
	const [rebateCustomer, setRebateCustomer] = useState("");
	const [productModal, setProductModal] = useState(false);
	const [customerModal, setCustomerModal] = useState(false);

	const toggleProductModal = () => setProductModal(!productModal);

	const toggleCustomerModal = () => setCustomerModal(!customerModal);

	const onProductFormSubmit = (e) => {
		toggleProductModal();
	};
	const onCustomerFormSubmit = (e) => {
		toggleCustomerModal();
	};

	const getProducts = () => {
		//return axios.get("https://hidden-shore-25886.herokuapp.com/products").then((response) => {
		return axios.get("/products").then((response) => {
			setProductList(response.data);
		});
	};
	useEffect(getProducts, []);

	const getCustomers = () => {
	//	return axios.get("https://hidden-shore-25886.herokuapp.com/customers").then((response) => {
		return axios.get("/customers").then((response) => {
			setCustomerList(response.data);
		});
	};
	useEffect(getCustomers, []);

	const handleGetRebatePrices = (customer) => {
	//	return axios.get(`https://hidden-shore-25886.herokuapp.com/customers/${customer.id}/discounts`).then((response) => {
		axios.get(`customers/${customer.id}/discounts`).then((response) => {
			setRebateProductList(response.data);
			setRebateCustomer(customer.name);
		});
	};

	const handleRemoveProduct = (product) => {
		axios.delete(`products/${product.id}`).then((response) => { });
		setProductList((products) => products.filter((it) => it !== product));
	};
	const handleRemoveCustomer = (customer) => {
		axios.delete(`customers/${customer.id}`).then((response) => { });
		setCustomerList((customers) => customers.filter((it) => it !== customer));
	};

	return (
		<div>
			<Container fluid>
				<Row>
					<Col xs={4}>
						<div style={{ display: "block", padding: 5, }}>
							<Button color="success" onClick={toggleProductModal}>
								Add product
							</Button>
							<Modal
								isOpen={productModal}
								toggle={toggleProductModal}
								modalTransition={{ timeout: 2000 }}
							>
								<ModalBody>
									<ProductForm
										onSubmit={onProductFormSubmit}
										setProductList={setProductList}
									/>
								</ModalBody>
							</Modal>
						</div>
					</Col>
					<Col xs={4}>
						<div style={{ display: "block", padding: 5, }}>
							<Button color="success" onClick={toggleCustomerModal}>
								Add customer
							</Button>
							<Modal
								isOpen={customerModal}
								toggle={toggleCustomerModal}
								modalTransition={{ timeout: 2000 }}
							>
								<ModalBody>
									<CustomerForm
										onSubmit={onCustomerFormSubmit}
										setCustomerList={setCustomerList}
									/>
								</ModalBody>
							</Modal>
						</div>
					</Col>
				</Row>
				<Row>
					<Col xs={4}>
						<ProductTable productList={productList} handleRemoveProduct={handleRemoveProduct}></ProductTable>
					</Col>
					<Col xs={4}>
						<CustomerTable customerList={customerList} handleGetRebatePrices={handleGetRebatePrices} handleRemoveCustomer={handleRemoveCustomer} ></CustomerTable>
					</Col>
					<Col xs={4}>
						<RebateTable rebateProductList={rebateProductList} rebateCustomer={rebateCustomer}></RebateTable>
					</Col>
				</Row>
			</Container>
		</div>
	);
};

export default App;
