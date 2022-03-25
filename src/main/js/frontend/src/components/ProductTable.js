import React from "react";
import {
	Button,
	ButtonGroup,
	Table,
} from "reactstrap";
import "bootstrap/dist/css/bootstrap.css";

const ProductTable = ({ productList, handleRemoveProduct }) => {
	return (
		<><div>
			<Table className="mt-4">
				<thead>
					<tr>
						<th align="left">Product</th>
						<th align="left">Standard price</th>
						<th align="left">Actions</th>
					</tr>
				</thead>
				<tbody>
					{productList.map((product) => (
						<tr key={product.id}>
							<td style={{ whiteSpace: "nowrap" }}>{product.name}</td>
							<td>{product.standardPrice} e</td>
							<td>
								<ButtonGroup>
									<Button
										size="sm"
										color="danger"
										onClick={() => handleRemoveProduct(product)}
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
export default ProductTable