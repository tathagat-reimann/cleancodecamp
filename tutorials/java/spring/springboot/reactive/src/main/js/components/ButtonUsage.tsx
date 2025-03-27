import * as React from 'react';
import Button from '@mui/material/Button';

interface ButtonUsageProps {
  label: string;
}

export default function ButtonUsage({ label }: ButtonUsageProps) {
  return <Button variant="contained">{label}</Button>;
}
