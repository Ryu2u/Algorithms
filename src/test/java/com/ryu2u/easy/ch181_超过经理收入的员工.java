package com.ryu2u.easy;

/**
 *
 Create table If Not Exists Employee (id int, name varchar(255), salary int, managerId int);
 Truncate table Employee;
 insert into Employee (id, name, salary, managerId) values ('1', 'Joe', '70000', '3');
 insert into Employee (id, name, salary, managerId) values ('2', 'Henry', '80000', '4');
 insert into Employee (id, name, salary, managerId) values ('3', 'Sam', '60000', null);
 insert into Employee (id, name, salary, managerId) values ('4', 'Max', '90000', null);


 表：Employee

 +-------------+---------+
 | Column Name | Type    |
 +-------------+---------+
 | id          | int     |
 | name        | varchar |
 | salary      | int     |
 | managerId   | int     |
 +-------------+---------+
 Id是该表的主键。
 该表的每一行都表示雇员的ID、姓名、工资和经理的ID。


 编写一个SQL查询来查找收入比经理高的员工。

 以 任意顺序 返回结果表。

 查询结果格式如下所示。



 示例 1:

 输入:
 Employee 表:
 +----+-------+--------+-----------+
 | id | name  | salary | managerId |
 +----+-------+--------+-----------+
 | 1  | Joe   | 70000  | 3         |
 | 2  | Henry | 80000  | 4         |
 | 3  | Sam   | 60000  | Null      |
 | 4  | Max   | 90000  | Null      |
 +----+-------+--------+-----------+
 输出:
 +----------+
 | Employee |
 +----------+
 | Joe      |
 +----------+
 解释: Joe 是唯一挣得比经理多的雇员。

 * @author Administrator
 * @Description:
 * @date 2023-06-30 13:28:51
 */
public class ch181_超过经理收入的员工	{

    /**
     SELECT a.name as Employee FROM employee as a join employee as b on a.managerId = b.id and a.salary > b.salary

     */

}