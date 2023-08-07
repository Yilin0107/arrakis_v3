import React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';

const BondCard = ({ bond }) => {
  return (
    <Card sx={{ minWidth: 275 }}>
      <CardContent>
        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
          {bond.issuerName}
        </Typography>
        <Typography variant="h5" component="div">
          ISIN: {bond.isin}
        </Typography>
        <Typography sx={{ mb: 1.5 }} color="text.secondary">
          Type: {bond.type}
        </Typography>
        <Typography variant="body2">
          Maturity Date: {bond.maturityDate}
        </Typography>
      </CardContent>
    </Card>
  );
};

export default BondCard;