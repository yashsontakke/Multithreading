
--use practice ;
--CREATE TABLE orders (
--    salesman_id INT NOT NULL,         -- Salesman ID
--    order_number VARCHAR(50) NOT NULL,
--    amount DECIMAL(10, 2) NOT NULL,
--    order_date DATE NOT NULL
--);
--
--INSERT INTO orders (salesman_id, order_number, amount, order_date)
--VALUES
--    (1, 'ORD001', 250.75, '2025-04-01'),
--    (2, 'ORD002', 500.50, '2025-04-02'),
--    (1, 'ORD003', 150.25, '2025-04-03'),
--    (3, 'ORD004', 400.00, '2025-04-04'),
--    (2, 'ORD005', 1000.00, '2025-04-05');

select salesman_id , sum(amount) from orders group by salesman_id ;

select * , sum(amount) over(partition by salesman_id order by order_date)  from orders ;

select * , sum(amount) over(order by order_date rows between 2 preceding and current row)  from orders ;

select * , sum(amount) over(order by order_date rows between 2 preceding and 1 preceding )  from orders ;
select * , sum(amount) over(order by order_date rows between 2 preceding and 1 following  )  from orders ;
select * , sum(amount) over(order by order_date rows between unbounded preceding and 1 following  )  from orders ;

// working as lag
select * , sum(amount) over(order by order_date rows between 1 preceding and 1 preceding )  from orders ;

// working as lead
select * , sum(amount) over(order by order_date rows between 1 following and 1 following )  from orders ;
