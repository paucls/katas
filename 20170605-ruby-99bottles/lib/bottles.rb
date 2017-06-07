class Bottles

  def song
    verses(99, 0)
  end

  def verses(from, to)
    from_verse = verse(from) + "\n"

    if from - to == 1
      from_verse + verse(to)
    else
      from_verse + verses(from - 1, to)
    end
  end

  def verse(count)
    if count.zero?
      return <<VERSE
No more bottles of beer on the wall, no more bottles of beer.
Go to the store and buy some more, 99 bottles of beer on the wall.
VERSE
    end

    verse = <<VERSE
#{count} bottle#{count == 1 ? '' : 's' } of beer on the wall, #{count} bottle#{count == 1 ? '' : 's' } of beer.
VERSE

    if count == 1
      verse += <<LINE
Take it down and pass it around, no more bottles of beer on the wall.
LINE
    else
      next_count = count - 1
      verse += <<LINE
Take one down and pass it around, #{next_count} bottle#{next_count == 1 ? '' : 's' } of beer on the wall.
LINE
    end

    verse
  end

end
