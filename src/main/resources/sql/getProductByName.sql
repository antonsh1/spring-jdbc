SELECT o.product_name FROM netology.customers c
                               INNER JOIN netology.orders o ON o.customer_id = c.id
WHERE c.name = :name;