import React from "react";
import {
	Button,
	ButtonGroup,
	Table,
} from "reactstrap";
import "bootstrap/dist/css/bootstrap.css";

const CustomerTable = ({ customerList, handleGetRebatePrices, handleRemoveCustomer }) => {
	return (
		<><div>
			<Table className="mt-4">
				<thead>
					<tr>
						<th align="left">Customer</th>
						<th align="left">Rebate type</th>
						<th align="left">Actions</th>
					</tr>
				</thead>
				<tbody>
					{customerList.map((customer) => (
						<tr key={customer.id}>
							<td style={{ whiteSpace: "nowrap" }}>{customer.name}</td>
							<td>{customer.rebateType}</td>
							<td>
								<ButtonGroup>
									<Button
										size="sm"
										color="primary"
										onClick={() => handleGetRebatePrices(customer)}
									>
										Calculate rebate
									</Button>
									<Button
										size="sm"
										color="danger"
										onClick={() => handleRemoveCustomer(customer)}
									>
										Delete
									</Button>
								</ButtonGroup>
							</td>
						</tr>
					))}
				</tbody>
			</Table>
		</div></>
	)
}
export default CustomerTable