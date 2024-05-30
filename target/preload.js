const { contextBridge, ipcRenderer } = require('electron')

// I want to write this file in kotlin! But I can't.
//
// Because:
// - Electron doesn't support ESM modules
// - Kotlin doesn't support webpack for NodeJS.
//
// As a result, I can't write preload script in kotlin.

contextBridge.exposeInMainWorld('versions', {
  node: () => process.versions.node,
  chrome: () => process.versions.chrome,
  electron: () => process.versions.electron,
  ping: () => ipcRenderer.invoke('ping')
})
