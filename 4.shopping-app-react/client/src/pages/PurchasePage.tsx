import { useParams } from "react-router-dom";

import {
  Card,
  CardContent,
  CardMedia, CircularProgress,
  Container,
  Grid,
  Typography,
} from "@mui/material";
import { PurchaseForm } from "../components/purchase";

import { getProduct } from "../utils/api"
import useAsync from "../hooks/useAsync"
import { NotFoundPage } from ".";
import { API_SERVER_DOMAIN } from "../constants";

type ParamsType = {
  productId: string;
};

const PurchasePage = () => {
  const { productId } = useParams<ParamsType>();
  const { data, loading } = useAsync(() => getProduct(productId));

  if (loading) return <CircularProgress />
  if (!data) return <NotFoundPage />

  const product = data.data.product;

  return (
    <Container maxWidth="sm">
      <Typography variant="h4" sx={{ marginBottom: 4 }}>
        구매하기
      </Typography>
      <Grid container spacing={2}>
        <Grid item xs={12}>
          <Card sx={{ display: "flex", marginBottom: 2 }}>
            {product?.thumbnail && (
              <CardMedia
                sx={{ width: 100, height: 100, marginRight: 2 }}
                image={`${API_SERVER_DOMAIN}/${product?.thumbnail}`}
                title="Product"
              />
            )}
            <CardContent>
              <Typography variant="h6">{product?.name}</Typography>
            </CardContent>
          </Card>
          <PurchaseForm />
        </Grid>
      </Grid>
    </Container>
  );
};

export default PurchasePage;