
//This class  will implement a quadratic equation, using basic instance variables

/**
 * 
 * @author Chrisotpher D
 *
 */

public class QuadraticExpression {

/**
 * setting instance variables
 
 */
	
	private double a;//coefficient for a
	private double b;//coefficient for b
	private double c;//coefficient for the constant
	
		/**
		 *default constructor that sets variables to zero 
		 *
		 */
		public QuadraticExpression()//this is a default constructor that initializes the variables
		{
			this.a=0;
			this.b=0;
			this.c=0;
		}
		// this constructor that three input for each root of the quadratic formula
		/**
		 * 
		 * @param a coefficient for x^2
		 * @param b coefficient for x
		 * @param c	constant c
		 */
		public QuadraticExpression( double a, double b, double c)
		{
			this.a=a;
			this.b=b;
			this.c=c;
		}
		//this constructor returns the string for the quadratic equation
		
		/**
		 * to String method that returns quadractic eqution
		 * 
		 */
		
		public String toString()
		{
			return ("The quadratic expression is: " + a + "x^2 + " + b +"x + " + c );
					
		}	

		//this method evaluates x in the quad equations and returns one single type double number
		
		/**
		 * 
		 * @param x number that is passed to quadratic equation and evaluates the quadratic equation
		 * @return single number that is evaluated in quadratic equation
		 */
		
		public double evaluate (double x)
		{
		return (a*x*x + b*x +c );
		}

		// below are the setMethod for all 3 private variables
		
		/**
		 * 
		 * @param newA local variable that is set to instance variable a
		 */
		public void SetA(double newA)// set method for A
		{
			newA=a;
		}
		/**
		 * 	
		 * @param newB local variable B that is set to instance variable b
		 */
		public void SetB(double newB)// setter for B
		{
			newB=b;
		}
		/**
		 * 
		 * @param newC local variable c that is set to instance variable c
		 */
		public void SetC(double newC)//setter for C
		{
			newC=c;
		}
	
		/**
		 * 
		 * @param r the number that is passed to scale each value of the equation
		 * @param q is an equation with an quadracticExpression type
		 * @return return a new equation that is scaled by the value of r
		 */
		// static method that returns a new quadractic equation that is scaled by r
		public static QuadraticExpression scale(double r, QuadraticExpression q)
		{
			QuadraticExpression newExpression = new QuadraticExpression ((r*q.a), (r*q.b), (r*q.c));
			return(newExpression);
			
		}

		// This method returns number of roots, 
		
		/**
		 * @return the number of roots: 0, 1, 2, 3(if infinite number)
		 */
		
		public int numberOfRoots()
		{
			
			if((a ==0) && (b==0) && (c==0))// if a,b,c are zeroo there is an infinite amount of roots so return 3
			{
				return 3;
			}
			else if((a != 0) && (b*b > 4*a*c))// so a is a nonzero and b^2>4ac two real roots
			{
				return 2;
			}
			else if((b*b== 4*a*c) || ((a==0) && (b!=0))) //if b^2 == 4ac, or a equals 0 and b doesnt equal zero then there is one real root
			{
				return 1;
			}
			else //
			{
				return 0;
			}
		}//end of the number of roots number
		
		/**
		 * 
		 * @param q1 new quadratic equation 
		 * @param q2 new quadratic equation
		 * @return returns a new expression where both q1 and q2 are added
		 */
		//This method is static and will simply add 2 Quadratic objects together
			public static  QuadraticExpression add(QuadraticExpression q1, QuadraticExpression q2)
			{
				QuadraticExpression newExpression1 =  new QuadraticExpression((q1.a+q2.a), (q1.b+q2.b) , (q1.c+q2.c));
				return (newExpression1);
			}
		
		
		//This method add q to the calling expression object
		/**
		 * 
		 * @param q an object of Quadratic expression that is being added to the calling object of q
		 */
			public void add(QuadraticExpression q)
			{
				a+=q.a;
				b+=q.b;
				c+=q.c;
			}
		/**
		 * 	
		 * @return returns the smaller roots if  applicable(two real roots) , or returns Double MaxValue if there is an infinite amount of roots
		 * @throws Exception if there are no roots, an exception is thrown
		 */
		//This method return the smaller root
			public double smallerRoot() throws Exception
			{
				double d=  (b*b - 4*a*c);//determinant of roots
				double r1= (-b+ Math.sqrt(b*b-(4*a*c)))/2*a;
				double r2= (-b- Math.sqrt(b*b-(4*a*c)))/2*a;
				
				if((a ==0) && (b==0) && (c==0))// if a,b,c are zeroo there is an infinite amount of roots so return 3
				{
					return  -Double.MAX_VALUE;//-1.79....
				}
				else if((a != 0) && (b*b > 4*a*c))// so a is a nonzero and b^2>4ac two real roots
				{
					if(r1<r2)
					{
						return r1;
					}
					else //if(r1>r2)
					{
						return r2;
					}
				}
				else if(b*b== 4*a*c) // one real root
					{
					return (-b/2*a);
					}
				else if((a==0) && (b!=0)) //one real root
				{
					return (-c/b);
				}
				else //
				{
					throw new Exception("There are no roots");// this case has no real roots
				}
				
				
			
			}//end of the smaller root method
			
			/**
			 * 
			 * @return returns the larger of the roots if applicable(two real roots), or returns Double MaxValue
			 * @throws Exception  if there are no roots, an exception is thrown
			 */
			public double largerRoot()throws Exception
			{

				double d=  (b*b - 4*a*c);//determinant of roots
				double r1= (-b+ Math.sqrt(b*b-(4*a*c)))/2*a;
				double r2= (-b- Math.sqrt(b*b-(4*a*c)))/2*a;
				
				if((a ==0) && (b==0) && (c==0))// if a,b,c are zeroo there is an infinite amount of roots so return 3
				{
					return  -Double.MAX_VALUE;//-1.79....
				}
				else if((a != 0) && (b*b > 4*a*c))// so a is a nonzero and b^2>4ac two real roots
				{
					if(r1>2)
					{
						return r1;
					}
					else //if(r1>r2)
					{
						return r2;
					}
				}
				else if(b*b== 4*a*c) // one real root
					{
					return (-b/2*a);
					}
				else if((a==0) && (b!=0)) //one real root
				{
					return (-c/b);
				}
				else //
				{
					throw new Exception("There are no roots");// this case has no real roots
				}
				
			}//largerRoot method end	
			
	
			/**
			 * 
			 * @param q object of Quadratic equation that compares it
			 * @return returns true  if both objects are equal or false if not
			 */
			public boolean equals (Object obj)
			{
				if( obj instanceof QuadraticExpression)
				{
					QuadraticExpression p = (QuadraticExpression) q;
				}
				if((a==q.a) && (b==q.b) && (c== q.c))
				{
					return true;
				}
				else 
				{
					return false;
				}
				
			}//end of equals method
		
			/**
			 * This method creates a clone of the calling object
			 */
			public QuadraticExpression clone()
			{
				QuadraticExpression p;
				
				try
				{
					p=(QuadraticExpression)super.clone();
				}
				catch(CloneNotSupportedException e)
				{
					throw new RuntimeException
					("This class does not implement cloneable");
				}
				return p;
			}
			
}//ends entire class
	
			
		
		
		
		

	
	





