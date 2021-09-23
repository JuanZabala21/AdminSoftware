const express = require('./server'); //your express app
const {app, BrowserWindow} = require('electron')

app.on('ready', function() {
    mainWindow = new BrowserWindow({
        width: 1280,
        height: 720,
        autoHideMenuBar: true,
        useContentSize: true,
        resizable: true,
    });
    mainWindow.loadURL('http://localhost:3000/');
    mainWindow.focus();
});
