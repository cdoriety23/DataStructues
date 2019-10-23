package com.company;
// this class will implement a polynomial with an array
//Author Christopher Doriety
import java.util.Arrays;

public class Polynomial

    {
        private int exponent;// this is a reference to the exponent for the polynomial
        private double[] coeff;// array that holds the coefficient and exponent

       // constructor that initializes instance fields
        public Polynomial()
        {
            exponent = 0;
            coeff = new double[1];
        }

        // constructors that creates a single polynomial with a signle coeff a0
        public Polynomial(double a0)
        {
            exponent = 0;
            coeff = new double[1];
            coeff[exponent] = a0;
        }

        // creates a copy of polynomial
        public Polynomial(Polynomial p)
        {
            exponent = p.exponent;//
            coeff = new double[exponent+1];
            for(int i=0; i<=exponent; i++)
            {
                coeff[i] = p.coeff[i];
            }
        }

        // method that add the given amount to the coefficienct of the specified amoutn
        public void add_to_coef(double amount, int exp)
        {
            double[] anotherCoeff;
            if(amount != 0)
            {
                if (exp >= coeff.length)
                {
                    anotherCoeff = new double[exp+1];
                    for(int i = 0; i <= exponent; i++) // array has to be <= degree because <= exponent is a java.lang.ArrayIndexOutOfBoundsException error
                    {
                        anotherCoeff[i] = coeff[i];
                    }
                    anotherCoeff[exp] = amount;
                    coeff = anotherCoeff;
                }
                else
                    coeff[exp] = coeff[exp] + amount;
                if(exponent < exp)
                    exponent = exp;
            }
        }
        // method that sets the coefficeint for the specified exponent
        public void assign_coef(double coefficient, int exp)
        {
            if(exp != 0)
            {
                if(exp >= coeff.length)
                {
                    double[] anothernewCoeff = new double[exp+1];
                    for(int i = 0; i < exponent; i++)
                    {
                        anothernewCoeff[i] = coeff[i];
                    }
                    anothernewCoeff[exp] = coefficient;
                    coeff = anothernewCoeff;
                }
                else
                    coeff[exp] = coefficient;
                if(exponent < exp)
                    exponent = exp;
            }
        }
        // Method that returns coefficient at a specified exponent of this polynomial
        public double coefficient(int exp)
        {
            if(exp > coeff.length)
                return 0;
            else
                return coeff[exp];
        }

       // method that evaluates a polynomial at a given input of x
        public double eval(double x)
        {
            double ans = 0;
            for (int i = exponent; i >= 0; i--)
                ans = coeff[i] + (x * ans);
            return ans;
        }
        // overriding equals method
        public boolean equals(Polynomial p)
        {
            if(p instanceof Polynomial)
            {
                Polynomial a = (Polynomial)p;
                if(exponent != a.exponent)
                    return false;
                else{
                    for(int i = 0; i < a.coeff.length; i++)
                    {
                        if(coeff[i] != a.coeff[i])
                            return false;
                    }
                    return true;
                }
            }
            return false;
        }

        // toString method
        public String toString()
        {
            String ans = "";
            for(int i = exponent; i >= 0; i--)
            {
                if(coeff[i] != 0)
                {
                    if(i > 0)
                    {
                        ans = ans + coeff[i] + "x^" + i;
                        ans = ans + "+";
                    }
                    else
                        ans = ans + coeff[0];
                }
            }
            return ans;
        }

        //returns a new polynomial of 2 added polynomials without changing current object of p
        public Polynomial add(Polynomial p)
        {
            Polynomial res = new Polynomial();
            if( p.exponent > exponent)
            {
                double[] coeff = new double[p.exponent+1];
                for(int i = 0; i <= exponent; i++)
                {
                    coeff[i] = coeff[i] + p.coeff[i];
                }
                coeff[p.exponent] = p.coeff[p.exponent];
                res.exponent = p.exponent;
                res.coeff = coeff;
            }
            else
                res.coeff[res.exponent] = p.coeff[p.exponent];
            return res;
        }

       // method that multiplies to polynomials with changing the current object of p
        public Polynomial multiply(Polynomial p)
        {
            Polynomial res = new Polynomial();
            for(int i = 0;  i < exponent; i++)
            {
                for(int j = 0;  j < p.exponent; j++)
                {
                    if(i == j)
                        res.add_to_coef(coeff[i] + p.coeff[j], i);
                    else
                        res.add_to_coef(coeff[i] + p.coeff[j], i*j);
                }
            }
            return res;
        }
    }
