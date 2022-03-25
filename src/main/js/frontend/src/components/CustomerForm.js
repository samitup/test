import React, { useState } from "react";
import { Button, Form, FormGroup, FormText, Label, Input } from "reactstrap";
import "bootstrap/dist/css/bootstrap.css";
import axios from "axios";

const CustomerForm = ({ onSubmit, setCustomerList }) => {
  const [customerName, setCustomerName] = useState("");
  const [customerRebateType, setCustomerRebateType] = useState("");
  const [warningText, setWarningText] = useState("");
  const addCustomer = (e) => {
    e.preventDefault();
    setWarningText("")
        if(customerName === '' || customerRebateType === ''){
            setWarningText("Name or rebate type is empty!")
            return;
          }
          else{
    onSubmit();

    var headers = {
      "Content-Type": "application/json",
    };
    const customer = {
      name: customerName,
      rebateType: customerRebateType,
    };
    axios
     // .post("https://hidden-shore-25886.herokuapp.com/customers", customer, headers)
     .post("/customers", customer, headers)
      .then((res) => setCustomerList((oldArray) => [...oldArray, res.data]));
      }
  };

  return (
    <Form onSubmit={addCustomer}>
      <FormGroup controlId="formCustomerName">
      <Label for="customerName">Customer name</Label>
        <Input
          type="text"
          placeholder="Enter customer name"
          value={customerName}
          onChange={(e) => setCustomerName(e.target.value)}
        />
      </FormGroup>

      <FormGroup controlId="formCustomerRebateType">
         <Label for="rebateType">Rebate type</Label>
                  <Input
                   type="select"
                    name="select"
                     id="select"
                      value={customerRebateType}
                       onChange={(e) => setCustomerRebateType(e.target.value)}
                       >

                  <option hidden value="">Click to select rebate type</option>
                    <option value = {"LONGTERMCUSTOMER"}>A long-term customer(15% discount)</option>
                    <option value = {"NEWCUSTOMER"}>A new customer(10% discount)</option>
                    <option value = {"NONE"}>No discounts</option>
                    <option value = {"FIXED_LAPTOP"}>Fixed $10 discount from laptops</option>
                  </Input>
      </FormGroup>
      <Button variant="primary" type="submit" block>
        Add
      </Button>
      <br/><FormText color="danger">{warningText}</FormText>
    </Form>
  );
};
export default CustomerForm;
