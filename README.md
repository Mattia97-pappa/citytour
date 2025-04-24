🌃 **City Tours**



👀 Il codice sorgente completo si trova in src, suddiviso in package chiari:

controller → gestione delle rotte

entity → entità del database

repository → interfaccia con il DB

security & config → login, autenticazione e accessi

▶️ Per eseguire il progetto Clona la repository con il seguente comando su gitbash

```codice
git clone https://github.com/Mattia97-pappa/citytour.git
cd citytour
```


Copia le tabelle per far funzionare il progetto. Per accedere come admin devi creare un admin come record nel database.

```admin
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `cittapub` varchar(255) DEFAULT NULL,
  `crawl_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
```
```crawl
CREATE TABLE `crawl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `posto_id` int(11) NOT NULL,
  `cittapub` varchar(255) DEFAULT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  `prezzo` int(11) DEFAULT NULL,
  `immagine` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `posto_id` (`posto_id`),
  CONSTRAINT `crawl_ibfk_1` FOREIGN KEY (`posto_id`) REFERENCES `posti` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
```
```posti
CREATE TABLE `posti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `citta` varchar(255) DEFAULT NULL,
  `descrizione` text DEFAULT NULL,
  `hostel` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `cittapub` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
```
```prenotazioni
CREATE TABLE `prenotazioni` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crawl_id` int(11) NOT NULL,
  `nome_cognome` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `data_evento` date NOT NULL,
  `quantita` int(11) NOT NULL DEFAULT 1,
  `created_at` date DEFAULT NULL,
  `prezzoTot` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `crawl_id` (`crawl_id`),
  CONSTRAINT `prenotazioni_ibfk_1` FOREIGN KEY (`crawl_id`) REFERENCES `crawl` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
```



City Tours è un'applicazione web full-stack basata su Java che consente ai viaggiatori di sfogliare, prenotare e gestire tour cittadini.



## 📌 **Funzionalità**

- Sfoglia i tour disponibili  
- Prenota i tour  
- Gli amministratori possono gestire le prenotazioni (CRUD), ciascuno limitato alla propria città



🛠️ **Tecnologie Utilizzate**

- Java  
- Spring Framework  
- Spring Security  
- JPA (Hibernate)  
- Bootstrap  
- JavaScript



 🎥 Demo



  
  [User Experience ](https://vimeo.com/1076039561)


  [Admin Experience](https://vimeo.com/1076034611)

