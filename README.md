# volleytest
This project is to demo how we can r equest to server and parse json data . originally created while demo to Anik

php code for making the RESTApi 

~~~~~~~~
********

<?php
	$conn = mysqli_connect("yourserveraddress", "yourusernamefordatabase","yourdbpassword","yourdatabasename");
	
	// Check connection
	if (!$conn) {
	    die("Connection failed: " . mysqli_connect_error());
	} 
	
	$fetch= array();
	
	$sql = "select * from std order by name";
	$result = mysqli_query($conn,$sql);
	if ($result ) {	
		}
	 else {
	    echo  mysqli_error($conn);
		}
		//fetching rows into array
	 while($row = $result->fetch_assoc())
	 {
	 	$fetch[]=$row;	 	
	 }
	echo json_encode($fetch);
	mysqli_close($conn);
?>


********
~~~~~~~~



sql script for making database

////////////////////////******************\\\\\\\\\\\\\\\\\\\\\\\

!!! creating table  !!!
CREATE TABLE IF NOT EXISTS `std` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

!!! inserting dummy data  !!!
INSERT INTO `std` (`id`, `name`, `age`) VALUES
(113400001, 'Morshed Alam Anik Mazumder Hingula ', 25),
(121400026, 'Shafiqur Rahman', 26),
(121400028, 'Tahmida Khair', 24),





////////////////////////******************\\\\\\\\\\\\\\\\\\\\\\\
