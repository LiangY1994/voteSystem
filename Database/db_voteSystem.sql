CREATE DATABASE db_voteSystem;

USE db_voteSystem;

CREATE TABLE tb_channel(
	channelID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	channelName VARCHAR(20) NOT NULL
);

CREATE TABLE tb_vote(
	voteID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	voteName VARCHAR(30) NOT NULL,
	channelID INT NOT NULL,
	FOREIGN KEY (channelID) REFERENCES tb_channel(channelID)
);

CREATE TABLE tb_option(
	optionID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	optionName VARCHAR(30) NOT NULL,
	optionNUMBER INT NOT NULL DEFAULT 0,
	voteID INT NOT NULL,
	FOREIGN KEY (voteID) REFERENCES tb_vote(voteID)
);