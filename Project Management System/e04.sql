-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2019 at 01:00 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e04`
--

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `fid` varchar(10) NOT NULL,
  `fname` varchar(30) NOT NULL,
  `subject` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`fid`, `fname`, `subject`) VALUES
('1701117512', 'MOHAIMEN- BIN- NOOR', 'OBJECT ORIENTED PROGRAMMING 1');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userid` varchar(10) NOT NULL,
  `password` varchar(8) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userid`, `password`, `status`) VALUES
('1701117512', '12345678', 1),
('17-34468-2', '12729311', 0),
('16-31722-1', '12534794', 0),
('16-32916-3', '18747855', 0),
('17-33302-1', '19159910', 0);

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `stid` varchar(10) NOT NULL,
  `oop principles` double(2,1) NOT NULL,
  `package` double(2,1) NOT NULL,
  `exception handling` double(2,1) NOT NULL,
  `database design and operation` double(2,1) NOT NULL,
  `frame navigation` double(2,1) NOT NULL,
  `presentation` double(2,1) NOT NULL,
  `total` double(2,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`stid`, `oop principles`, `package`, `exception handling`, `database design and operation`, `frame navigation`, `presentation`, `total`) VALUES
('16-31722-1', 4.0, 3.0, 4.0, 3.0, 5.0, 5.0, 0.0),
('17-34468-2', 5.0, 5.0, 4.0, 5.0, 5.0, 5.0, 0.0);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `stid` varchar(10) NOT NULL,
  `stname` varchar(30) NOT NULL,
  `section` varchar(2) NOT NULL,
  `grpid` varchar(4) NOT NULL,
  `prname` varchar(50) NOT NULL,
  `fmarks` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`stid`, `stname`, `section`, `grpid`, `prname`, `fmarks`) VALUES
('16-31722-1', 'SADIQ, MD FARHAN ', 'D', 'D05', 'Library Management System', 25.00),
('16-32916-3', 'AHAMMAD, HASAN ', 'D', 'D09', 'Restaurant Management System', 24.00),
('17-33302-1', 'RAHMAN, IFTEKHAR', 'A', 'A03', 'Hospital Management System', 22.00),
('17-34468-2', 'MOBIN, MOHETUZZAMAN ', 'E', 'E09', 'MCQ Management and Quiz System', 29.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`stid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
