import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';

describe('App', () => {
  it('renders without errors', () => {
    render(<App />);
    // Check that the component renders without throwing any errors
  });

  it('displays a welcome message', () => {
    render(<App />);
    const welcomeMessage = screen.getByText(/Welcome to My App/i);
    expect(welcomeMessage).toBeInTheDocument();
  });

  it('updates state when button is clicked', () => {
    render(<App />);
    const button = screen.getByRole('button');
    const initialCount = screen.getByText(/Count: 0/i);

    expect(initialCount).toBeInTheDocument();

    // Simulate a button click
    button.click();

    const updatedCount = screen.getByText(/Count: 1/i);
    expect(updatedCount).toBeInTheDocument();
  });
});
