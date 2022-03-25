import React from "react";
import { Table } from "reactstrap";
import "bootstrap/dist/css/bootstrap.css";

const RebateTable = ({ rebateProductList, rebateCustomer }) => {
	return (
		<><div>
			<Table className="mt-4">
				<thead>
					<tr>
						<th align="left">Product</th>
						<th align="left">Rebate price</th>
						<th align="left">For customer</th>
					</tr>
				</thead>
				<tbody>
					{rebateProductList.map((product) => (
						<tr key={product.id}>
							<td style={{ whiteSpace: "nowrap" }}>{product.name}</td>
							<td>{product.standardPrice} e</td>
							<td>{rebateCustomer}</td>
						</tr>
					))}
				</tbody>
			</Table>
		</div></>
	)
}
export default RebateTable