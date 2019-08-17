-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 11 Août 2019 à 00:27
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `news`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE IF NOT EXISTS `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `contenu` text NOT NULL,
  `dateCreation` datetime NOT NULL,
  `dateModification` datetime NOT NULL,
  `supprime` int(11) NOT NULL,
  `categorie` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `article`
--

INSERT INTO `article` (`id`, `titre`, `contenu`, `dateCreation`, `dateModification`, `supprime`, `categorie`) VALUES
(1, 'Premi?re victoire du S?n?gal', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', '2019-08-06 00:00:00', '2019-08-06 00:00:00', 0, 1),
(2, 'Election en Mauritanie', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', '2019-08-06 00:00:00', '2019-08-06 00:00:00', 0, 4),
(3, 'D?but de la CAN', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', '2019-08-06 00:00:00', '2019-08-06 00:00:00', 0, 1),
(4, 'P?trole au S?n?gal', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', '2019-08-06 00:00:00', '2019-08-06 00:00:00', 0, 4),
(5, 'Inauguration d''un ENO ? l''UVS', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', '2019-08-06 00:00:00', '2019-08-06 00:00:00', 0, 3),
(6, 'test2', 'gyfjvhvghcvbbbbbbbbbbbbbbvvvvfdcfffddddddddddddddddddddddddddddddddddddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxrrrrr', '2019-08-09 00:00:00', '2019-08-09 00:00:00', 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(256) NOT NULL,
  `supprime` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`id`, `nom`, `supprime`) VALUES
(1, 'Sport', 0),
(2, 'Sante', 0),
(3, 'Education', 0),
(4, 'Politique', 0);

-- --------------------------------------------------------

--
-- Structure de la table `fonctionnalite`
--

CREATE TABLE IF NOT EXISTS `fonctionnalite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(256) NOT NULL,
  `description` varchar(500) NOT NULL,
  `etat` varchar(255) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `fonctionnalite`
--

INSERT INTO `fonctionnalite` (`id`, `nom`, `description`, `etat`) VALUES
(1, 'fGesUsers', 'gérer les utilisateurs', 'Active'),
(2, 'fGesGroupes', 'Gestion des groupes', 'Active'),
(3, 'fGestion', 'fGestion', 'Active'),
(4, 'fSupprimer', 'Gestion de la Suppression', 'Active'),
(5, 'fModifier', 'Gestion de la modification', 'Active'),
(6, 'fGesArticles', 'Gestion des Articles', 'Active'),
(7, 'fGesCategories', 'Gestion des Categories', 'Active');

-- --------------------------------------------------------

--
-- Structure de la table `fonctionnalitegroupe`
--

CREATE TABLE IF NOT EXISTS `fonctionnalitegroupe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idFonctionnalite` int(11) NOT NULL,
  `idGroupe` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `fonctionnalitegroupe`
--

INSERT INTO `fonctionnalitegroupe` (`id`, `idFonctionnalite`, `idGroupe`) VALUES
(1, 4, 2),
(2, 5, 2),
(3, 3, 2),
(4, 6, 2),
(5, 7, 2);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE IF NOT EXISTS `groupe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `etat` int(255) NOT NULL,
  `supprime` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `groupe`
--

INSERT INTO `groupe` (`id`, `nom`, `description`, `etat`, `supprime`) VALUES
(1, 'SUPER ADMINISTRATEUR', 'Les membres du groupe administrateurs ont tous les droits', 0, 0),
(2, 'editeurs ', '(lister, ajouter, supprimer ou modifier) les articles et les catégories. ', 0, 0),
(3, 'visiteurs', ' la consultation des articles (affichage par catégorie, etc.) ', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_prenom` varchar(256) NOT NULL,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `groupe` int(11) NOT NULL,
  `etat` int(11) NOT NULL,
  `supprime` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `nom_prenom`, `login`, `password`, `groupe`, `etat`, `supprime`) VALUES
(1, 'Oum Lekhoutt Sidi Mohamed', 'oumou', 'e0d89f2507a542ffe8fd0a5da91ec2e8', 1, 0, 0),
(2, 'Sidi Mohamed', 'sidi', 'c55cf71cb2c8189f908065d186c2abf8', 2, 0, 0),
(5, 'Ahmed Salem', 'salem', 'fa0612a2a952fa001aca35e3f6fe7ef3', 3, 0, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
