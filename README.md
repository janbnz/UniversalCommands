# UniversalCommands

> Send commands to all connected spigot servers with only one command!

[![Build Status](http://img.shields.io/travis/badges/badgerbadgerbadger.svg?style=flat-square)](https://travis-ci.org/badges/badgerbadgerbadger) 
[![Coverage Status](http://img.shields.io/coveralls/badges/badgerbadgerbadger.svg?style=flat-square)](https://coveralls.io/r/badges/badgerbadgerbadger)
[![License](http://img.shields.io/:license-unlicense-blue.svg?style=flat-square)](http://badges.unlicense-license.org)

**Example**

![Example GIF](http://g.recordit.co/CUwnE1JP1y.gif)

**API**

![API GIF](http://g.recordit.co/0hBvxNClDP.gif)

---

## Example

```java
public static void main(String[] args) throws IOException {
    UniversalCommands.getApi().sendRequest("time set 0");
}
```

### Clone

- Clone this repo to your local machine using `https://github.com/Seltrox/UniversalCommands.git`

## Documentation
- Coming soon

## Dependencies

- <a href="https://www.spigotmc.org/" target="_blank">Spigot</a> for the spigot plugin.
- <a href="https://ci.md-5.net/job/BungeeCord/" target="_blank">BungeeCord</a> for the bungeecord plugin.
- <a href="https://www.rabbitmq.com/" target="_blank">RabbitMQ</a> as message broker.

---

## Contributing

> To get started...

### Step 1

- **Option 1**
    - 🍴 Fork this repo!

- **Option 2**
    - 👯 Clone this repo to your local machine using `https://github.com/Seltrox/UniversalCommands.git`

### Step 2

- **HACK AWAY!** 🔨🔨🔨

### Step 3

- 🔃 Create a new pull request using <a href="https://github.com/Seltrox/UniversalCommands/compare/" target="_blank">`https://github.com/Seltrox/UniversalCommands/compare/`</a>.

---

## FAQ

- **What is UniversalCommands?**
    - With UniversalCommands you can execute a command to all connected spigot servers.
    
- **What is needed for UniversalCommands?**
    - For UniversalCommands you need at least:
      - A <a href="https://www.spigotmc.org/" target="_blank">Spigot</a> server.
      - A <a href="https://ci.md-5.net/job/BungeeCord/" target="_blank">BungeeCord</a> server.
      - A <a href="https://www.rabbitmq.com/" target="_blank">RabbitMQ</a> server.
    
- **How can I use UniversalCommands?**
    - Just execute ```/executeAll **your command**```
  
---

## License

[![License](http://img.shields.io/:license-unlicense-blue.svg?style=flat-square)](http://badges.unlicense-license.org)

- **[The Unlicense](https://unlicense.org/)**
- Copyright 2020 © <a href="http://seltrox.de/" target="_blank">Jan Benz</a>.
