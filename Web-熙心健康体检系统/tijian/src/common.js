// 存数据
export function setSessionStorage(key, val) {
  sessionStorage.setItem(key, JSON.stringify(val))
}

// 取数据
export function getSessionStorage(key) {
  const data = sessionStorage.getItem(key)
  return data ? JSON.parse(data) : null
}

// 删除数据
export function removeSessionStorage(key) {
  sessionStorage.removeItem(key)
}