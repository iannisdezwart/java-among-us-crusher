const fs = require('fs')
const s = fs.readFileSync('Game/gameContents.txt', 'utf-8')
const lines = s.split('\n')

const fileOut = lines.length + '\n\n' + lines
	.map(l => {
		const out = []
		let i = 0

		while (true)
		{
			i = l.indexOf('&', i + 1)

			if (i == -1) break

			let j = i + 1

			while (/[0-9]|-/.test(l[j]))
			{
				j++
			}

			out.push(parseInt(l.substring(i + 1, j)))
		}

		return out
	})
	.map(arr => `${ arr.length } ${ arr.join(' ') }`)
	.join('\n')

fs.writeFileSync('input.txt', fileOut)